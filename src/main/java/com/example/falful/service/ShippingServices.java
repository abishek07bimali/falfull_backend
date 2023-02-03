package com.example.falful.service;

import com.example.falful.entity.ShippingAddress;
import com.example.falful.pojo.ShippingAddressPojo;

import java.util.List;

public interface ShippingServices {
    ShippingAddressPojo save(ShippingAddressPojo shippingAddressPojo);
    List<ShippingAddress> findAll();
}
