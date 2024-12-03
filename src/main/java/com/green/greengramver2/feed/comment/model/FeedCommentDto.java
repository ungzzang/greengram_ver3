package com.green.greengramver2.feed.comment.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

//Data Transfer Object
@Getter
@Setter
@Schema(title = "피드 댓글 상세")
public class FeedCommentDto {
    @Schema(title = "피드 댓글 PK")
    private long feedCommentId;
    @Schema(title = "피드 댓글 내용")
    private String comment;
    @Schema(title = "피드 댓글 작성자 유저 PK")
    private long writerUserId;
    @Schema(title = "피드 댓글 작성자 유저 이름")
    private String writerNm;
    @Schema(title = "피드 댓글 작성자 유저 프로필 사진 파일명")
    private String writerPic;
}
//(댓글 쓴 사용자를 눌렀을때 그 사용자의 프로필로 가기위해서 userId가 필요)
//(댓글 구분하려면 pk값인 feedCommentId가 필요함)