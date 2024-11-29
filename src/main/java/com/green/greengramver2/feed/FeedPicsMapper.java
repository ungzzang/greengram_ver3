package com.green.greengramver2.feed;

import com.green.greengramver2.feed.model.FeedGetRes;
import com.green.greengramver2.feed.model.FeedPicDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FeedPicsMapper {
    //여러개 한꺼번에 넣을꺼라 Pics로 했다.
    //mybatis 작업하는 용도로 보내는거다.
    int insFeedPics(FeedPicDto p);
    int insFeedPics2(FeedPicDto p);
    List<String> selFeedPics(long feedId);
}
