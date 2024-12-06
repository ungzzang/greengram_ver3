package com.green.greengram.user;

import com.green.greengram.common.MyFileUtils;
import com.green.greengram.user.model.UserSignInReq;
import com.green.greengram.user.model.UserSignInRes;
import com.green.greengram.user.model.UserSignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final MyFileUtils myFileUtils;

    public int signUp(MultipartFile pic, UserSignUpReq p){
        String savedPicName = (pic != null ? myFileUtils.makeRandomFileName(pic) : null);

        String hashedPassWord = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());

        p.setUpw(hashedPassWord);
        p.setPic(savedPicName);

        int result = mapper.insUser(p);

        if(pic == null){
            return result;
        }

        long userId = p.getUserId();
        String middlePath = String.format("user/%d", userId);
        myFileUtils.makeFolders(middlePath);
        String filePath = String.format("%s/%s", middlePath, savedPicName);

        try{
            myFileUtils.transferTo(pic, filePath); //file이 임시파일에 있는데 우리가 관리하는 폴더로 옮기는거
        }catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public UserSignInRes signIn(UserSignInReq p){
        UserSignInRes res = mapper.selUserByUid(p.getUid());

        if(res == null){
            res = new UserSignInRes();
            res.setMessage("아이디를 확인하시오");
            return res;
        }else if(!BCrypt.checkpw(p.getUpw(), res.getUpw())){
            res = new UserSignInRes();
            res.setMessage("비밀번호를 확인하시오");
            return res;
        }

        res.setMessage("로그인 성공");
        return res;
    }
}
