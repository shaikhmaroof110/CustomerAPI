package com.DA.CustmerAPI.mapper;

import com.DA.CustmerAPI.DTO.ShippingAddressDto;
import com.DA.CustmerAPI.entities.ShippingAddressEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShippingAddressMapper {

    @Autowired
    public static  ModelMapper mapper;

    public static ShippingAddressDto convertToDto(ShippingAddressEntity shippingAddressEntity)
    {
       return mapper.map(shippingAddressEntity, ShippingAddressDto.class );
    }
    public static ShippingAddressEntity convertToEntity(ShippingAddressDto shippingAddressDto)
    {
        return  mapper.map(shippingAddressDto, ShippingAddressEntity.class);
    }
}
