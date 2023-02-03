package com.example.falful.service;


import com.example.falful.entity.User;
import com.example.falful.pojo.UserPojo;

import java.io.IOException;
import java.util.List;

public interface UserService {
//    UserPojo save(UserPojo userPojo);
    List<User> fetchAll();

    String save(UserPojo userPojo);

     User fetchById(Integer id);

     void deleteById(Integer id);

    User findByEmail(String email);
}
