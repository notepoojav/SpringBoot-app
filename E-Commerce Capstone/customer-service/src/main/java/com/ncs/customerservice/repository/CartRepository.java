package com.ncs.customerservice.repository;

import com.ncs.customerservice.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {


    List<Cart> findAllByUsernameAndOrderId(String customerName, int i);

  }
