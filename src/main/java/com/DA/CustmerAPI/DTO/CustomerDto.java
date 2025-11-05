package com.DA.CustmerAPI.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
public class CustomerDto {

    private Integer cId;
    private String name;
    private String password;
    private String pwdUpdated;     //To check random pwd updated or not.
    private String email;
    private String phoneNo;
    private LocalDate dateCreated;
    private LocalDate lastUpdated;
}
