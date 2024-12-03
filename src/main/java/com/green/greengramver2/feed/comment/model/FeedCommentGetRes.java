package com.green.greengramver2.feed.comment.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedCommentGetRes {
    private boolean moreComment;
    private List<FeedCommentDto> commentList;
}

