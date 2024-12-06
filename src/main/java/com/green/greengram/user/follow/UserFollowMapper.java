package com.green.greengram.user.follow;

import com.green.greengram.user.follow.model.UserFollowReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFollowMapper {
    int postUserFollow(UserFollowReq p);
    int deleteUserFollow(UserFollowReq p);
}
