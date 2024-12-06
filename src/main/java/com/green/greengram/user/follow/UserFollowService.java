package com.green.greengram.user.follow;

import com.green.greengram.user.UserMapper;
import com.green.greengram.user.follow.model.UserFollowReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFollowService {
    private final UserFollowMapper mapper;

    public int postUserFollow(UserFollowReq p){
        int result = mapper.postUserFollow(p);
        return result;
    }

    public int deleteUserFollow(UserFollowReq p){
        int result = mapper.deleteUserFollow(p);
        return result;
    }
}
