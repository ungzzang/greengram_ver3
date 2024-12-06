package com.green.greengram.feed.comment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(title = "피드 댓글")
public class FeedCommentGetRes { // 이거 2개만 빼서 활용하려고, 더보기 기능도 봐야하고. (FeedGetRes에 동시에 넣어도 되긴함 활용때문에 나눈거)
    @Schema(title = "피드 댓글 더보기 여부")
    private boolean moreComment;
    @Schema(title = "피드 댓글 리스트")
    private List<FeedCommentDto> commentList; //3개담긴다.(3개이하면), 4개면 하나뺀다.(무조건 3개이하만 담김)
}

