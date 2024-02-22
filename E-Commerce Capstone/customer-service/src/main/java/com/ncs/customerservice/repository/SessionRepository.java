package com.ncs.customerservice.repository;

import com.ncs.customerservice.entity.MySessions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<MySessions,Integer> {
    List<MySessions> findByCustomerName(String customerName);

    List<MySessions> findAllByCustomerName(String customerName);
}
