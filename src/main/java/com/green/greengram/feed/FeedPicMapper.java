package com.green.greengram.feed;

import com.green.greengram.feed.model.FeedPicDto;
import com.green.greengram.feed.model.FeedPicSel;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FeedPicMapper {
    //여러개 한꺼번에 넣을꺼라 Pics로 했다.
    //mybatis 작업하는 용도로 보내는거다.
    int insFeedPic(FeedPicDto p);
    int insFeedPic2(FeedPicDto p);
    List<String> selFeedPic(long feedId);
    List<FeedPicSel> selFeedPicListByFeedIds(List<Long> feedIds);
}
