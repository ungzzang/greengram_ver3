package com.green.greengram.feed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
/*
    feed_pics 테이블에 튜플 여러개를 insert
    한문장으로 처리하기 위해 사용하는 객체
    FeedPostRes랑 멤버필드가 같지만 하는 역할이 다르다.
 */
public class FeedPicDto {
    //feedId와 사진들
    private long feedId;
    private List<String> pics;
}
