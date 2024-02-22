package com.ncs.customerservice.service;

import com.ncs.customerservice.entity.Cards;
import com.ncs.customerservice.entity.Cart;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public interface CartService {


    void addToCart(List<Cart> cartList);

    List<Cart> getOrdersList(String customerName);

    void savecard(Cards data) throws NoSuchAlgorithmException;
}
