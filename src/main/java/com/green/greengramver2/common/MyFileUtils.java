package com.green.greengramver2.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
public class MyFileUtils {
    private final String uploadPath;

    public MyFileUtils(@Value("${file.directory}") String uploadPath) {
        log.info("MyFileUtiles - 생성자: {}", uploadPath);
        this.uploadPath = uploadPath;
    }

    public String makeFolders(String path) {
        File file = new File(uploadPath, path);

        if(!file.exists()){
            file.mkdirs();
        }

        return file.getAbsolutePath();
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
        File file = new File(uploadPath, path);
        multipartFile.transferTo(file);
    }
}
