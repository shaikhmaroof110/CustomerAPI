package com.DA.CustmerAPI.service;

import com.DA.CustmerAPI.DTO.CustomerDto;
import com.DA.CustmerAPI.DTO.ResetPasswordDto;

public interface CustomerService {


    public CustomerDto saveCustomer(CustomerDto customerDto);

    public CustomerDto login(String email, String password);

    public boolean resetPwd(ResetPasswordDto resetPasswordDto);

    public CustomerDto getCustomerByEmail(String email);

    public CustomerDto updateCustomer(CustomerDto customerDto);

}
