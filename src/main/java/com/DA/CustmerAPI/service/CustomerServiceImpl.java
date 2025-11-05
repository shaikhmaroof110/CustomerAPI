package com.DA.CustmerAPI.service;

import com.DA.CustmerAPI.DTO.CustomerDto;
import com.DA.CustmerAPI.DTO.ResetPasswordDto;
import com.DA.CustmerAPI.entities.CustomerEntity;
import com.DA.CustmerAPI.mapper.CustomerMapper;
import com.DA.CustmerAPI.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Random;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = CustomerMapper.convertToEntity(customerDto);  // ctr + ALt + V

        String tempPwd = generateRandomPassword(6);
        customerEntity.setPassword(tempPwd);
        customerEntity.setPwdUpdated("NO");

        CustomerEntity saved = customerRepository.save(customerEntity);

        String subject = "";
        String body = "";

        boolean status = emailService.sendEmail(subject, body, customerDto.getEmail());

        if(status)
        {
            return CustomerMapper.convertToDto(saved);
        }

        return null;
    }

    @Override
    public CustomerDto login(String email, String password) {
        CustomerEntity customerEntity = customerRepository.findByEmailAndPassword(email,password);
        if(customerEntity!=null)
        {
            return CustomerMapper.convertToDto(customerEntity);
        }

        return null;
    }

    @Override
    public boolean resetPwd(ResetPasswordDto resetPasswordDto) {

        CustomerEntity customerEntity = customerRepository.findByEmail(resetPasswordDto.getEmail());
        if(customerEntity !=null)
        {
            customerEntity.setPassword(resetPasswordDto.getNewPassword());
            customerEntity.setPwdUpdated("YES");
            CustomerEntity saved = customerRepository.save(customerEntity);
            return true;
        }
        return false;
    }

    @Override
    public CustomerDto getCustomerByEmail(String email) {
        CustomerEntity customerEntity = customerRepository.findByEmail(email);
        if(customerEntity!=null)
        {
            return CustomerMapper.convertToDto(customerEntity);
        }
        return null;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = CustomerMapper.convertToEntity(customerDto);
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        return  CustomerMapper.convertToDto(savedCustomer);
    }

    // Generate random password
    private String generateRandomPassword(int pwdLength)
    {
        Random random = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder buffer = new StringBuilder(pwdLength);
        for(int i=0;i<pwdLength;i++)
        {
            int randomIndex = random.nextInt(chars.length());
            char ch = chars.charAt(randomIndex);
            buffer.append(ch);

        }
        return buffer.toString();
    }
}
