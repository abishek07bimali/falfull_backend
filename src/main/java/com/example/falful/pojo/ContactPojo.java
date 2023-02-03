package com.example.falful.pojo;

import com.example.falful.entity.Contact;
import com.example.falful.entity.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactPojo {
    private Integer id;
    private String email;
    private  String mobile_no;
    private  String fullname;
    private  String subject;
    private  String message;
    private  int contact_user_id;

//    private MultipartFile image;

    public ContactPojo(Contact contact) {
        this.id=contact.getId();
        this.email=contact.getEmail();
        this.mobile_no=contact.getMobileNo();
        this.fullname=contact.getFullname();
        this.subject=contact.getSubject();
        this.message=contact.getMessage();
        this.contact_user_id=contact.getUser_id().getId();
    }
}
