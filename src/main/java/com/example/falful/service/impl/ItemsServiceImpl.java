package com.example.falful.service.impl;

import com.example.falful.entity.Items;
import com.example.falful.entity.User;
import com.example.falful.pojo.ItemsPojo;
import com.example.falful.repo.ItemsRepo;
import com.example.falful.service.ItemsServices;
import lombok.RequiredArgsConstructor;
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
public class ItemsServiceImpl implements ItemsServices {

    private final ItemsRepo itemsRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/fruit_images";


    @Override
    public ItemsPojo save(ItemsPojo itemsPojo) throws IOException {
        Items items;
        if (itemsPojo.getId() != null) {
            items = itemsRepo.findById(itemsPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            items = new Items();
        }
        items.setItems_name(itemsPojo.getItems_name());
        items.setPrice(itemsPojo.getPrice());
        items.setQuantity(itemsPojo.getQuantity());

        if(itemsPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, itemsPojo.getImage().getOriginalFilename());
            fileNames.append(itemsPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, itemsPojo.getImage().getBytes());

            items.setImage(itemsPojo.getImage().getOriginalFilename());

    }
        itemsRepo.save(items);
        return new ItemsPojo(items);
    }

    @Override
    public List<Items> fetchAll() {
        return this.itemsRepo.findAll();
    }

    @Override
    public Items fetchById(Integer id) {
        return itemsRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void deleteById(Integer id) {
        itemsRepo.deleteById(id);
    }


}
