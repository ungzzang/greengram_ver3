package com.green.greengramver2.feed.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Schema(title = "피드 등록 응답")
public class FeedPostRes {
    //ver.1에서는 feedId, pics 안줘도 되긴하지만 주는걸로 했음
    @Schema(title = "피드 pk")
    private long feedId;
    @Schema(title = "피드 사진 리스트")
    private List<String> pics;
}
