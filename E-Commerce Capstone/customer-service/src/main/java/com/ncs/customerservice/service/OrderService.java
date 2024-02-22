package com.ncs.customerservice.service;

import com.ncs.customerservice.entity.Orders;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {


    void saveorder(Orders data);
}
