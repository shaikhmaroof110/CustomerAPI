package com.DA.CustmerAPI.repositories;

import com.DA.CustmerAPI.DTO.CustomerDto;
import com.DA.CustmerAPI.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    public void customerLogin(String email, String password);
    public CustomerDto resetPassword(String password);
    public CustomerDto getCustomerByEmail(String email);
    public CustomerDto updateCustomer(Integer cId);
    public List<CustomerDto> getALlCustomer();
    // save customer
    public CustomerDto saveCustomer(CustomerDto customerDto);



}
