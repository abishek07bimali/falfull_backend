package com.example.falful.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="items")
public class Items{
    @Id
    @SequenceGenerator(name = "jps_items_seq_gen", sequenceName = "jps_items_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "jps_items_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "items_name")
    private String items_name;

    @Column(name = "price")
    private String price;
    @Column(name = "quantity")
    private String quantity;

    @Column(name = "image")
    private String image;

    @Transient
    private String imageBase64;



}
