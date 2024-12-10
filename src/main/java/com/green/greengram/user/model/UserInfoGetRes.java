package com.green.greengram.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Schema(title = "유저 정보 GET 응답")
public class UserInfoGetRes {
    @Schema
    private long userId;
    @Schema
    private String pic;
    private String createdAt;
    @Schema
    private String nickName;
    @Schema
    private int follower;
    @Schema
    private int following;
    @Schema(title = "등록한 피드 수 ")
    private int feedCount;
    @Schema(title = "피드 좋아요 숫자", description = "프로필 사용자의 피드에 달린 좋아요 수")
    private int myFeedLikeCount;
    @Schema(title = "팔로우 상태")
    private int followState;
}
