package com.green.greengram.feed.like;

import com.green.greengram.feed.like.model.FeedLikeReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedLikeMapper {
    int insFeedLike(FeedLikeReq p);
    int delFeedLike(FeedLikeReq p);
}
