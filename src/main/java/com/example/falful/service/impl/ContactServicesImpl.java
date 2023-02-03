package com.example.falful.service.impl;

import com.example.falful.config.PasswordEncoderUtil;
import com.example.falful.entity.Contact;
import com.example.falful.entity.User;
import com.example.falful.pojo.ContactPojo;
import com.example.falful.pojo.UserPojo;
import com.example.falful.repo.ContactRepo;
import com.example.falful.repo.UserRepo;
import com.example.falful.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ContactServicesImpl implements ContactService {
    private  final ContactRepo contactRepo;
    private  final UserRepo userRepo;
    @Override
    public ContactPojo save(ContactPojo contactPojo) {
        Contact contact;
        if (contactPojo.getId() != null) {
            contact = contactRepo.findById(contactPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            contact = new Contact();
        }
        contact.setFullname(contactPojo.getFullname());
        contact.setMobileNo(contactPojo.getMobile_no());
        contact.setEmail(contactPojo.getEmail());
        contact.setMessage(contactPojo.getMessage());
        contact.setSubject(contactPojo.getSubject());
        contact.setUser_id(userRepo.findById(contactPojo.getContact_user_id()).orElseThrow());

        contactRepo.save(contact);
        return new ContactPojo(contact);    }

    @Override
    public List<Contact> findAll() {
        return this.contactRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        contactRepo.deleteById(id);
    }

}
