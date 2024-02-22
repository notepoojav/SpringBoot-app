package com.ncs.customerservice.repository;

import com.ncs.customerservice.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Cards,Integer> {
    List<Cards> findAllByUsername(String customerName);
}
