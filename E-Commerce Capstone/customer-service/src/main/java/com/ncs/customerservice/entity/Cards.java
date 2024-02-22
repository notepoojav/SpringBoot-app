package com.ncs.customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cards")
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String username;

    String name;

    String cardnumber;

    String type;

    String expiry;

    String cvv;

}