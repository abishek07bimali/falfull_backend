package com.example.falful.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users",
        uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_user_email", columnNames = "email")
})

public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column()
    private String email;

    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "address")
    private String address;


    @Column(name = "password")
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "cart",
//            foreignKey = @ForeignKey(name = "FK_users_items_userId"),
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseForeignKey = @ForeignKey(name = "FK_users_product_productId"),
//            inverseJoinColumns = @JoinColumn(name = "items_id", referencedColumnName = "id"),
//            uniqueConstraints = @UniqueConstraint(name = "UNIQUE_users_Product_userIdProductId",
//                    columnNames = {"user_id", "items_id"})
//    )



//    @Column(name = "image")
//    private String image;
//
//    @Transient
//    private String imageBase64;
//@ManyToMany(fetch = FetchType.EAGER)
//@JoinTable(name = "User_Billing",
//        foreignKey = @ForeignKey(name = "FK_users_roles_userId"),
//        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//        inverseForeignKey = @ForeignKey(name = "FK_users_roles_roleId"),
//        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
//        uniqueConstraints = @UniqueConstraint(name = "UNIQUE_users_roles_userIdRoleId",
//                columnNames = {"user_id", "role_id"})
//)



//private Collection<Items> items;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
//        return getRoles().stream().map(role -> new SimpleGrantedAuthority(role.get())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
