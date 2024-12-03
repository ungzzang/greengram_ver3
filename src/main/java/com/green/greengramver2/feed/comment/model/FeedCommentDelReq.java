package com.green.greengramver2.feed.comment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

import java.beans.ConstructorProperties;

@ToString
@Getter
public class FeedCommentDelReq {
    @Schema(name = "feed_comment_id") //프론트한테 이 이름으로 날린다는거 알리기
    private long feedCommentId;
    @Schema(name = "signed_user_id")
    private long userId;


    //@ConstructorProperties - 다 수정할때
    @ConstructorProperties({"feed_comment_id", "signed_user_id"})
    public FeedCommentDelReq(long feedCommentId, long userId){
        this.feedCommentId = feedCommentId;
        this.userId = userId;
    }
}
