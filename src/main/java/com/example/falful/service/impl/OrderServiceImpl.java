package com.example.falful.service.impl;

import com.example.falful.entity.Contact;
import com.example.falful.entity.Order;
import com.example.falful.pojo.ContactPojo;
import com.example.falful.pojo.OrderPojo;
import com.example.falful.repo.ItemsRepo;
import com.example.falful.repo.OrderRepo;
import com.example.falful.repo.UserRepo;
import com.example.falful.service.OrderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderServices {
    private  final OrderRepo orderRepo;
    private  final UserRepo userRepo;
    private  final ItemsRepo itemsRepo;
    @Override
    public OrderPojo save(OrderPojo orderPojo) {
        Order order;
        if (orderPojo.getId() != null) {
            order = orderRepo.findById(orderPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            order = new Order();
        }
        order.setUser_id(userRepo.findById(orderPojo.getUser_id()).orElseThrow());
        order.setOrdered_product(itemsRepo.findById(orderPojo.getProduct_id()).orElseThrow());
        order.setQuantity(orderPojo.getQuantity());

        orderRepo.save(order);
        return new OrderPojo(order);
    }

    @Override
    public List<Order> fetchAll() {
        return this.orderRepo.findAll();
    }
}
