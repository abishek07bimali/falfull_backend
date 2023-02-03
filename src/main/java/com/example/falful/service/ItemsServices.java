package com.example.falful.service;

import com.example.falful.entity.Items;
import com.example.falful.entity.User;
import com.example.falful.pojo.ItemsPojo;

import java.io.IOException;
import java.util.List;

public interface ItemsServices {
    ItemsPojo save(ItemsPojo itemsPojo) throws IOException;
    List<Items> fetchAll();
    Items fetchById(Integer id);

    void deleteById(Integer id);




}
