package com.green.greengram.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoGetReq {
    private long signedUserId;
    private long profileUserId;
}
