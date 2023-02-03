package com.example.falful.pojo;

import com.example.falful.entity.ShippingAddress;
import com.example.falful.entity.User;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddressPojo {
    private Integer id;
    private  String fullname;
    private  String zipcode;
    private  String state;
    private  String city;
    private  String moreAddress;
    private  String streetAddress;
    private  String email;
    private  String billing_address;
    private  String phone;
    private  String billing_name;

//    private  int Order_id;


    public ShippingAddressPojo(ShippingAddress shippingAddress) {
        this.id=shippingAddress.getId();
        this.fullname=shippingAddress.getFullname();
        this.state=shippingAddress.getState();
        this.zipcode=shippingAddress.getZipcode();
        this.moreAddress=shippingAddress.getDetailAddress();
        this.city=shippingAddress.getCity();
        this.streetAddress=shippingAddress.getStreetaddress();
        this.email=shippingAddress.getEmail();
        this.phone=shippingAddress.getPhone();
        this.billing_address=shippingAddress.getBilling_address();
        this.billing_name=shippingAddress.getBillingname();
//        this.Order_id=shippingAddress.getOrder_Id().getId();
    }
}
