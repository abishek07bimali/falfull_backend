package com.example.falful.service;

import com.example.falful.entity.Contact;
import com.example.falful.pojo.ContactPojo;

import java.util.List;

public interface ContactService {
    ContactPojo save(ContactPojo contactPojo);
    List<Contact> findAll();

    void deleteById(Integer id);
}
