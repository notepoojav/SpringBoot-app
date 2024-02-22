package com.ncs.customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "My_Sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MySessions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String customerName;

    private String sessionkey;

    @Temporal(TemporalType.TIMESTAMP)
    Date date = new Date();

}
