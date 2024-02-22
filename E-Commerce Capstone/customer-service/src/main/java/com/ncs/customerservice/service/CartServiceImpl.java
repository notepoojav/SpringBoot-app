package com.ncs.customerservice.service;

import com.ncs.customerservice.entity.Cards;
import com.ncs.customerservice.entity.Cart;
import com.ncs.customerservice.repository.CardRepository;
import com.ncs.customerservice.repository.CartRepository;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CardRepository cardRepository;

    @Override
    public void addToCart(List<Cart> cartList) {

        cartRepository.saveAll(cartList);

    }
    @Override
    public List<Cart> getOrdersList(String customerName) {
        return cartRepository.findAllByUsernameAndOrderId(customerName,0);
    }

    @Override
    public void savecard(Cards data) throws NoSuchAlgorithmException {
        String cvv = data.getCvv();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(cvv.getBytes());

        byte[] resultByteArray = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : resultByteArray) {
            sb.append(String.format("%02x", b));
        }
        String hashedCVV= sb.toString();
        data.setCvv(hashedCVV);
        cardRepository.save(data);
    }

}
