package com.green.greengramver2.feed;

import com.green.greengramver2.feed.model.FeedPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedMapper {
    int insFeed(FeedPostReq p);


}
