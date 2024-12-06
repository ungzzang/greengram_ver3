package com.green.greengram.user.follow.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

import java.beans.ConstructorProperties;

@Getter
@ToString
public class UserFollowReq {
    @JsonProperty("from_user_id") //프론트에서 스네이크 or 카멜케이스 로 보내는거 다 받을수 있다.
    @Schema(name = "from_user_id", description = "팔로워 유저 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long fromUserId;

    @JsonProperty("to_user_id")
    @Schema(name = "to_user_id", description = "팔로잉 유저 ID", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private long toUserId;

    @ConstructorProperties({"from_user_id", "to_user_id"})
    public UserFollowReq(long fromUserId, long toUserId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
    }
}
