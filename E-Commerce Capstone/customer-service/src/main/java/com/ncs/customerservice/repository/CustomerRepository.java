package com.ncs.customerservice.repository;

import com.ncs.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByEmail(String email);

    List<Customer> findAllByCustomerName(String customerName);

    List<Customer> findAllByEmail(String email);
}
