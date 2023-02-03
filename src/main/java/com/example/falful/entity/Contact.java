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
@Table(name="contact")

public class Contact{
    @Id
    @SequenceGenerator(name = "jps_contact_seq_gen", sequenceName = "jps_contact_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "jps_contact_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column()
    private String email;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "Subject")
    private String subject;

    @Column(name = "message")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Contact_User_Id", referencedColumnName = "id")
    private User user_id;

}
