package com.green.greengramver2.feed.model;

import com.green.greengramver2.common.model.Paging;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

@Slf4j
@Getter
//@ToStirng: FeedGetReq의 ToString 메소드를 오버라이딩한다.
@ToString(callSuper = true) //부모가 있는 값도 ToString으로 찍히게 해줌
public class FeedGetReq extends Paging {
    // name은 스웨거헤서 try out할 때 이 키값으로 날리고 싶을때 사용. 안쓰면 signedUserId로 날아감.
    @Schema(title = "로그인 유저 PK", name = "signed_user_id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long signedUserId; //로그인한 사용자의 pk를 받음(사용자가 좋아요를 눌렀는지 보려고)

    //@ConstructorProperties({"page", "size", "signed_user_id"}) 많은양을 저렇게 보내고 싶을때,쿼리스트링으로 보낼때
    //@BindParam - 파라미터 각각 바꾸고 싶을때, key값은 카멜케이스기법을 주로 사용.
    //날아온 key와 받고싶은 멤버필드명이 다를때 맵핑하려고 사용.
    public FeedGetReq(Integer page, Integer size, @BindParam("signed_user_id") long signeduserId) {
        super(page, size);
        this.signedUserId = signeduserId;
        log.info("page: {}, size: {}, signeduserId: {}", page, size, signeduserId);
    }
}
// 보내는 방식은 쿼리스트링과 body 2가지가 있다.
// 우리가 보내는 json은 body에 담긴다.(res는 body로 응답함), post방식, put방식
// 쿼리스트링은 get방식과 delete방식에서 주로 사용.
// formdata는 파일업로드 같은 경우에 사용하기도한다.
