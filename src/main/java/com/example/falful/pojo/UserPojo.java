package com.example.falful.pojo;

import com.example.falful.entity.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPojo {
    private Integer id;
    private String email;
    private  String mobile_no;
    private  String fullname;
    private  String password;
    private  String address;

//    private MultipartFile image;

    public UserPojo(User user) {
      this.id=user.getId();
      this.email=user.getEmail();
      this.mobile_no=user.getMobileNo();
      this.fullname=user.getFullname();
      this.password=user.getPassword();
      this.address=user.getAddress();
    }
}
