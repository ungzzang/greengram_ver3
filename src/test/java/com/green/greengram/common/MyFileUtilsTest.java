package com.green.greengram.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MyFileUtilsTest {
        private final String FILE_DIRECTORY = "D:/mydownload/greengram_ver3";
        private MyFileUtils myFileUtils;

        @BeforeEach //객체 생성 자동으로 각각 해줌(한번 해놓으면 따로 안해도됨)
        void setUp() {
            myFileUtils = new MyFileUtils(FILE_DIRECTORY);
        }

        @Test
        void deleteFolder() {
            String path = String.format("%s/ddd", myFileUtils.getUploadPath());
            myFileUtils.deleteFolder(path, false);
        }
}