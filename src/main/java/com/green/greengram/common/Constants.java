package com.green.greengram.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component //빈등록
public class Constants {
    private static int default_page_size;

    @Value("${const.default-page-size}")
    public void setDefaultPageSize(int value) { //value에 @Value옆 값을 넣는거다.(20)
        default_page_size = value; //static 멤버필드에 값 넣음 (20)
    }

    public static int getDefault_page_size() {
        return default_page_size;
    }
}