package com.green.greengramver2.user;

import com.green.greengramver2.user.model.UserSignInReq;
import com.green.greengramver2.user.model.UserSignInRes;
import com.green.greengramver2.user.model.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpReq p);

    //이번엔 uid하나로 해봄, xml에서 비밀번호는 필요없고 uid만 필요하니까
    UserSignInRes selUserByUid(String uid);
}
