package com.green.greengram.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component //빈등록
public class MyFileUtils {
    private final String uploadPath;

    public MyFileUtils(@Value("${file.directory}") String uploadPath) {
        log.info("MyFileUtiles - 생성자: {}", uploadPath);
        this.uploadPath = uploadPath;
    }

    //D:/2024-02/download/greengram_ver1/feed/2 이건 파일 디렉토리다.(보통 확장자 없는걸)
    public String makeFolders(String path) {
        // 파라미터 1개일때는 파일 풀 경로를 넣어준다. (파라미터 한개받는 생성자)
        // 파라미터 2개 값을 합칠껀데 "/"넣어줌 ("/" 없을때) (파라미터 2개받는 생성자)
        File file = new File(uploadPath, path);

        if(!file.exists()){ //파일이 없을때
            file.mkdirs(); //make directory
        }

        return file.getAbsolutePath(); //여기서 이건 딱히 쓸모없음, 그래서 리턴없애고 타입을 void해도 됨
    }

    public String getExt(String fileName){
        int lastIdx = fileName.lastIndexOf(".");
        return fileName.substring(lastIdx);
    }

    public String makeRandomFileName(){
        return UUID.randomUUID().toString();
    }

    public String makeRandomFileName(String originalFileName){
        return makeRandomFileName() + getExt(originalFileName);
    }

    public String makeRandomFileName(MultipartFile file){
        return makeRandomFileName(file.getOriginalFilename());
    }

    public void transferTo(MultipartFile multipartFile, String path) throws IOException {
        File file = new File(uploadPath, path); //2개의 경로 합친다.
        multipartFile.transferTo(file);
    }
}
