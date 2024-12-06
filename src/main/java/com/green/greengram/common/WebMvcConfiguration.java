package com.green.greengram.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //빈등록 (@Componeent 써도됨 상속이라서.)
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final String uploadPath; //final 붙은 멤버필드는 = "ㅁㅁ" 이렇게 하거나 생성자로 값넣기 가능

    //final 쓰고 싶어서 밑에 방식으로 넣음. 생성자로(final은 무조건)
    public WebMvcConfiguration(@Value("${file.directory}")String uploadPath) {
        this.uploadPath = uploadPath;
    }

    //@Bean 이거 있어야 @Configuration 얘가 의미있음
    //@Bean이랑 @Configuration 이거 같이 있으면 싱글톤으로 쓸수있다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/pic/**")
                .addResourceLocations("file:" + uploadPath + "/");
    }//스프링이 얘네 알아서 호출함.


    @Override
    public void configurePathMatch(PathMatchConfigurer configurer){
        // RestController의 모든 URL에 "/api" prefix를 생성, api가 앞에 붙게된다. ex) localhost:8080/api/feed?page=10&size=20
        configurer.addPathPrefix("api", HandlerTypePredicate.forAnnotation(RestController.class));
        //컨트롤러에서만 api붙인다. 다른곳은 안붙여도됨
    }
}
