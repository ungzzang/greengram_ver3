package com.green.greengram.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

public class UserPicPatchReq {
    private long signedUserId;
    private MultipartFile pic; //파일 그자체

    @JsonIgnore
    private String picName;
}
