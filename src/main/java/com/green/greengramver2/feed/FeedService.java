package com.green.greengramver2.feed;

import com.green.greengramver2.common.MyFileUtils;
import com.green.greengramver2.feed.comment.FeedCommentMapper;
import com.green.greengramver2.feed.comment.model.FeedCommentDto;
import com.green.greengramver2.feed.comment.model.FeedCommentGetReq;
import com.green.greengramver2.feed.comment.model.FeedCommentGetRes;
import com.green.greengramver2.feed.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper feedMapper;
    private final FeedPicsMapper feedPicsMapper;
    private final FeedCommentMapper feedCommentMapper;
    private final MyFileUtils myFileUtils;

    @Transactional //설명필요, 트랜잭션은 하나의 작업 단위로 간주되어, 모든 작업이 성공하면 커밋(Commit)되고, 하나라도 실패하면 롤백(Rollback)되어 이전 상태로 복구된다.
    public FeedPostRes postFeed(List<MultipartFile> pics, FeedPostReq p){
        int result = feedMapper.insFeed(p);

        //----------------파일 등록
        long feedId = p.getFeedId();

        //저장 폴더 만들기, 저장위치/feed/${feedId}/파일들을 저장한다.
        String middlePath = String.format("feed/%d",feedId);
        myFileUtils.makeFolders(middlePath);

        //랜덤 파일명 저장용 >> feed_pics 테이블에 저장할 때 사용
        List<String> picNameList = new ArrayList<>(pics.size()); //pics.size()없어도 결과는 같음

        for(MultipartFile pic : pics){
            //각 파일 랜덤파일명 만들기
            String savedFileName = myFileUtils.makeRandomFileName(pic);
            picNameList.add(savedFileName);
            String filePath = String.format("%s/%s", middlePath, savedFileName);

            try {
                myFileUtils.transferTo(pic, filePath);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        FeedPicDto feedPicDto = new FeedPicDto();
        feedPicDto.setFeedId(feedId);
        feedPicDto.setPics(picNameList);//리스트에 담은 사진들을 통째로 넘긴다. ver1에서는 for문으로 사진하나하나 집어넣음.
        int resultPics = feedPicsMapper.insFeedPics(feedPicDto); //버전2에서는 for문 밖에서 한번만 쿼리문 호출함(이게 더 효율이 좋음), 그래서 xml에서 foreach사용했다

        //@Setter 사용했을때
        /*FeedPostRes res = new FeedPostRes();
        res.setFeedId(feedId);
        res.setPics(picNameList);*/

        //@Builder 사용했을때
        return FeedPostRes.builder()
                .feedId(feedId)
                .pics(picNameList)
                .build();
    } // 이 하나의 업무를 하나의 트랜젝션이라고 한다.

    public List<FeedGetRes> getFeedList(FeedGetReq p) {
        // N + 1 이슈 발생
        List<FeedGetRes> list = feedMapper.selFeedList(p); //여기서 한 번 셀렉트
        for(FeedGetRes item : list) {
            //피드 당 사진 리스트
            item.setPics(feedPicsMapper.selFeedPics(item.getFeedId())); //여기서 (튜플 4개라면) 4 번 셀렉트

            //피드 당 댓글 4개
            FeedCommentGetReq commentGetReq = new FeedCommentGetReq();// 맵퍼한테 보낼꺼다.
            commentGetReq.setPage(1); //피드당 댓글 3개 들고오는 첫번째 페이지(startIdx, size 다 세팅됨)
            commentGetReq.setFeedId(item.getFeedId());

            List<FeedCommentDto> commentList = feedCommentMapper.selFeedCommentList(commentGetReq);

            FeedCommentGetRes commentGetRes = new FeedCommentGetRes();
            commentGetRes.setCommentList(commentList);
            commentGetRes.setMoreComment(commentList.size() == 4); // 4개면 true, 4개 아니면 false

            if(commentGetRes.isMoreComment()) {
                commentList.remove(commentList.size() - 1);
            }
            item.setComment(commentGetRes);
        }
        return list;
    }
}
