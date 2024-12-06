package com.green.greengram.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Schema(title = "회원가입")
public class UserSignUpReq {
    @JsonIgnore
    private long userId;
    @JsonIgnore
    private String pic;
    @Schema(title = "유저아이디", example = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private String uid;
    @Schema(title = "유저비밀번호", example = "PassWord", requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    @Schema(title = "유적닉네임")
    private String nickName;

    //실제로 프론트로 받을꺼는 uid, upw, nickName
    //사진은 파일로 받지 파일명으로 받는게 아니라서 @JsonIgnore 붙인거
    //@JsonIgnore, @Schema 얘네는 스웨거 때문에 넣는거지 없어도 동작함.
}
