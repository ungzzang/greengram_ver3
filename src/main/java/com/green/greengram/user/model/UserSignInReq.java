package com.green.greengram.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInReq {
    private String uid;
    private String upw;
}
