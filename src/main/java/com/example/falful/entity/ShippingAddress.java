package com.example.falful.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="shipping")

public class ShippingAddress {
    @Id
    @SequenceGenerator(name = "shipping_seq_gen", sequenceName = "shipping_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "shipping_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column()
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "street_address")
    private String streetaddress;

    @Column(name = "detailAddress")
    private String detailAddress;

    @Column(name = "billing_name")
    private String billingname;

    @Column(name = "email")
    private String email;
    @Column(name = "billing_address")
    private String billing_address;
    @Column(name = "phone")
    private String phone;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_product_Id", referencedColumnName = "id")
//    private Order Order_Id;

}
