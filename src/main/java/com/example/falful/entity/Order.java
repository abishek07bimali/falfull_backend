package com.example.falful.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customerorder")

public class Order{
    @Id
    @SequenceGenerator(name = "jps_order_seq_gen", sequenceName = "jps_order_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "jps_order_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_user_Id", referencedColumnName = "id")
    private User user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_product_Id", referencedColumnName = "id")
    private Items ordered_product;

    @Column(name = "quantity")
    private String quantity;

}
