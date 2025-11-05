package com.DA.CustmerAPI.mapper;


import com.DA.CustmerAPI.DTO.CustomerDto;
import com.DA.CustmerAPI.entities.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerMapper {

    @Autowired
    public static  ModelMapper mapper;

    public static CustomerDto convertToDto(CustomerEntity customerEntity)
    {
        return mapper.map(customerEntity, CustomerDto.class);
    }
    public static CustomerEntity convertToEntity(CustomerDto customerDto)
    {
        return mapper.map(customerDto, CustomerEntity.class);
    }
}
// we can also use bean