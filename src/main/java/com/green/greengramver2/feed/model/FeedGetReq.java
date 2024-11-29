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
@ToString(callSuper = true) //부모가 있는 값도 ToString으로 찍히게 해줌
public class FeedGetReq extends Paging {
    @Schema(title = "로그인 유저 PK", name = "signed_user_id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long signedUserId;

    //@ConstructorProperties({"page", "size", "signed_user_id"}) 많은양을 저렇게 보내고 싶을때,쿼리스트링으로 보낼때
    //@BindParam - 파라미터 각각 바꾸고 싶을때
    public FeedGetReq(Integer page, Integer size, @BindParam("signed_user_id") long signeduserId) {
        super(page, size);
        this.signedUserId = signeduserId;
        log.info("page: {}, size: {}, signeduserId: {}", page, size, signeduserId);
    }
}
