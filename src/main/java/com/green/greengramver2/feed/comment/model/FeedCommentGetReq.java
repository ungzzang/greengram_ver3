package com.green.greengramver2.feed.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedCommentGetReq {
    private final static int FIRST_COMMENT_SIZE = 3;
    private final static int DEFAULT_PAGE_SIZE = 20;

    @Schema(title = "피드 pk", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long feedId;

    private int page; //얘는 없어도 상관없음

    @JsonIgnore
    private int startIdx;

    @JsonIgnore
    private int size;

    public void setPage(int page) {
        if(page < 1) { return; }
        if(page == 1) {
            startIdx = 0;
            size = FIRST_COMMENT_SIZE + 1; // +1은 isMore처리용
            return;
        }
        startIdx = ((page - 2) * DEFAULT_PAGE_SIZE) + FIRST_COMMENT_SIZE;
        size = DEFAULT_PAGE_SIZE + 1; // +1은 isMore처리용
    }
    //다음댓글이 있는지 확인하려고 튜플 1개씩 더 보는거다.
    //+1해서 확인한거는 보지않고 다음 페이지 처음에 나타나는거다.(말그대로 확인용)
}
