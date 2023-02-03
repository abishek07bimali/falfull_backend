package com.example.falful.pojo;

import com.example.falful.entity.Order;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPojo {
    private Integer id;
    private int user_id;
    private int product_id;
    private  String quantity;

//    private MultipartFile image;

    public OrderPojo(Order order) {
        this.id=order.getId();
        this.user_id=order.getUser_id().getId();
        this.product_id=order.getOrdered_product().getId();
        this.quantity=order.getQuantity();

    }
}
