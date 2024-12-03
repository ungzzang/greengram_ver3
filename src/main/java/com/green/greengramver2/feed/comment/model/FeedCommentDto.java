package com.green.greengramver2.feed.comment.model;


import lombok.Getter;
import lombok.Setter;

//Data Transfer Object
@Getter
@Setter
public class FeedCommentDto {
    private long feedCommentId;
    private long writerUserId;
    private String comment;
    private String WriterNm;
    private String writerPic;
}
//(댓글 쓴 사용자를 눌렀을때 그 사용자의 프로필로 가기위해서 userId가 필요)
//(댓글 구분하려면 pk값인 feedCommentId가 필요함)