package com.DA.CustmerAPI.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "shipping_addr")
public class ShippingAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addr_Id;
    private String house_num;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String addType;
    private String deleteSw;

    @OneToMany
    @JoinColumn(name = "cId")   // foreign key
    private CustomerEntity customer;

}
