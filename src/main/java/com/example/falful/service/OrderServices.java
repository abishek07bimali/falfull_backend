package com.example.falful.service;

import com.example.falful.entity.Order;
import com.example.falful.pojo.OrderPojo;

import java.util.List;

public interface OrderServices {

    OrderPojo save(OrderPojo orderPojo);
    List<Order> fetchAll();
};
