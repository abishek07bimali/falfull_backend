package com.example.falful.pojo;

import com.example.falful.entity.Items;
import com.example.falful.entity.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemsPojo {
    private Integer id;
    private String items_name;
    private  String price;
    private  String quantity;

    private MultipartFile image;

    public ItemsPojo(Items items) {
        this.id=items.getId();
        this.items_name=items.getItems_name();
        this.price=items.getPrice();
        this.quantity=items.getQuantity();
    }
}
