package com.example.falful.repo;

import com.example.falful.entity.Contact;
import com.example.falful.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepo extends JpaRepository<ShippingAddress,Integer> {
}
