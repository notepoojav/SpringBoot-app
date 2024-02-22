package com.ncs.customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart_ekart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;

    private String username;

    private Integer productId;

    private Integer orderId;

    private String productName;

    private Integer quantity;

    private Integer price;

    private Integer amount;


}
