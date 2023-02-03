package com.example.falful.service.impl;

import com.example.falful.config.PasswordEncoderUtil;
import com.example.falful.entity.User;
import com.example.falful.exception.AppException;
import com.example.falful.pojo.UserPojo;
import com.example.falful.repo.UserRepo;
import com.example.falful.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepo userRepo;
    public List<User> fetchAll(){
        return this.userRepo.findAll();
    }

    @Override
    public String save(UserPojo userPojo) {
        User user=new User();
        if(userPojo.getId()!=null){
            user.setId(userPojo.getId());
        }
        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setMobileNo(userPojo.getMobile_no());
        user.setAddress(userPojo.getAddress());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));


        userRepo.save(user);
//        return new UserPojo(user);
        return "created";    }

    @Override
    public User fetchById(Integer id) {
        User user= userRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        user=User.builder()
                .id(user.getId())

                .fullname(user.getFullname())
                .email(user.getEmail())
                .mobileNo(user.getMobileNo())
//                .imageBase64(getImageBase64(user.getImage()))
                .build();
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);

    }

    @Override
    public User findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return user;
    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/Jobs_Image_Server/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }


}

