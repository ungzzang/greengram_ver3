package com.green.greengram.user;

import com.green.greengram.user.follow.model.UserPicPatchReq;
import com.green.greengram.user.model.UserInfoGetReq;
import com.green.greengram.user.model.UserInfoGetRes;
import com.green.greengram.user.model.UserSignInRes;
import com.green.greengram.user.model.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpReq p);

    //이번엔 uid하나로 해봄, xml에서 비밀번호는 필요없고 uid만 필요하니까
    UserSignInRes selUserByUid(String uid);

    UserInfoGetRes selUserInfo(UserInfoGetReq p);
    UserInfoGetRes selUserInfo2(UserInfoGetReq p); //실제로 이거 쓸꺼임(최종)

    int updUserPic(UserPicPatchReq p);
}
