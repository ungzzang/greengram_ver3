package com.green.greengram.user;

import com.green.greengram.user.model.UserSignInRes;
import com.green.greengram.user.model.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpReq p);

    //이번엔 uid하나로 해봄, xml에서 비밀번호는 필요없고 uid만 필요하니까
    UserSignInRes selUserByUid(String uid);
}
