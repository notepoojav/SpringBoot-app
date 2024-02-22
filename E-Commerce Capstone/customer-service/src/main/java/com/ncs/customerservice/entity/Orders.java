package com.ncs.customerservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String username;

    Double totalcost;

    String paymentstatus = "success";

    String cardnumber;

    Integer productCount;

    @Temporal(TemporalType.TIMESTAMP)
    Date date = new Date();

}