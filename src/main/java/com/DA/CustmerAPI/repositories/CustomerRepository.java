package com.DA.CustmerAPI.repositories;

import com.DA.CustmerAPI.DTO.CustomerDto;
import com.DA.CustmerAPI.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {


    public CustomerEntity findByEmailAndPassword(String email, String pwd);

    public CustomerEntity findByEmail(String email);



}
