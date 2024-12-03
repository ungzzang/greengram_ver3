package com.green.greengramver2.feed.comment;

import com.green.greengramver2.feed.comment.model.FeedCommentPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper mapper;

    public long postFeedComment(FeedCommentPostReq p){
        int result = mapper.insFeedComment(p);
        //mapper.insFeedComment(p); 도 가능
        return p.getFeedCommentId();
    }
}
