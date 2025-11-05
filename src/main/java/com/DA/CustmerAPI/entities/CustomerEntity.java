package com.DA.CustmerAPI.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer cId;
    private String name;
    private String password;
    private String pwdUpdated;     //To check random pwd updated or not.
    private String email;
    private String phoneNo;


    @CreationTimestamp
    private LocalDate dateCreated;

    @UpdateTimestamp
    private LocalDate lastUpdated;


}
