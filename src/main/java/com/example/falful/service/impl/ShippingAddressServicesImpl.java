package com.example.falful.service.impl;

import com.example.falful.entity.Items;
import com.example.falful.entity.ShippingAddress;
import com.example.falful.pojo.ItemsPojo;
import com.example.falful.pojo.ShippingAddressPojo;
import com.example.falful.repo.OrderRepo;
import com.example.falful.repo.ShippingRepo;
import com.example.falful.service.ShippingServices;
import com.example.falful.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingAddressServicesImpl implements ShippingServices {
    private  final ShippingRepo shippingRepo;
    private  final OrderRepo orderRepo;
    @Override
    public ShippingAddressPojo save(ShippingAddressPojo shippingAddressPojo) {
        ShippingAddress shippingAddress;
        if (shippingAddressPojo.getId() != null) {
            shippingAddress = shippingRepo.findById(shippingAddressPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            shippingAddress = new ShippingAddress();
        }
        shippingAddress.setFullname(shippingAddressPojo.getFullname());
        shippingAddress.setCity(shippingAddressPojo.getCity());
        shippingAddress.setState(shippingAddressPojo.getState());
        shippingAddress.setZipcode(shippingAddressPojo.getZipcode());
        shippingAddress.setStreetaddress(shippingAddressPojo.getStreetAddress());
        shippingAddress.setDetailAddress(shippingAddressPojo.getMoreAddress());
        shippingAddress.setBilling_address(shippingAddressPojo.getBilling_address());
        shippingAddress.setEmail(shippingAddressPojo.getEmail());
        shippingAddress.setPhone(shippingAddressPojo.getPhone());
        shippingAddress.setBillingname(shippingAddressPojo.getBilling_name());
//        shippingAddress.setOrder_Id(orderRepo.findById(shippingAddressPojo.getId()).orElseThrow());
//
//        if(itemsPojo.getImage()!=null){
//            StringBuilder fileNames = new StringBuilder();
//            System.out.println(UPLOAD_DIRECTORY);
//            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, itemsPojo.getImage().getOriginalFilename());
//            fileNames.append(itemsPojo.getImage().getOriginalFilename());
//            Files.write(fileNameAndPath, itemsPojo.getImage().getBytes());
//
//            items.setImage(itemsPojo.getImage().getOriginalFilename());
//
//        }
        shippingRepo.save(shippingAddress);
        return new ShippingAddressPojo(shippingAddress);
    }

    @Override
    public List<ShippingAddress> findAll() {
        return this.shippingRepo.findAll();
    }

}
