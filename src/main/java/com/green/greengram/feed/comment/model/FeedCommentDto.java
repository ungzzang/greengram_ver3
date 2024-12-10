package com.green.greengram.feed.comment.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

//Data Transfer Object
//순수하게 데이터를 담는데 집중된 객체, 로직은 없고 Getter와 Setter만 이루어져있음
//컨트롤러와 서비스 등 계층간 데이터를 전송
@Getter
@Setter
@Schema(title = "피드 댓글 상세")
public class FeedCommentDto {
    @JsonIgnore
    private long feedId;
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