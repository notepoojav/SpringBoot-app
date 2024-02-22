package com.ncs.customerservice.service;

import com.ncs.customerservice.entity.Cart;
import com.ncs.customerservice.entity.Orders;
import com.ncs.customerservice.repository.CartRepository;
import com.ncs.customerservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository cartRepository;
    @Override
    public void saveorder(Orders data) {

            orderRepository.save(data);

        List<Cart> purchases = cartRepository.findAllByUsernameAndOrderId(data.getUsername(), 0) ;

        ArrayList<Cart> arrayList = new ArrayList();
        for(int i = 0; i < purchases.size(); i++) {
            Cart cart = purchases.get(i);
            cart.setOrderId(data.getId());
            arrayList.add(cart);
        }
        cartRepository.saveAll(arrayList);
    }
}
