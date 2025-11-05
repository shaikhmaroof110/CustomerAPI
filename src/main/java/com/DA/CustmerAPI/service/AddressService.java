package com.DA.CustmerAPI.service;

import com.DA.CustmerAPI.DTO.ShippingAddressDto;

import java.util.List;

public interface AddressService {


    public ShippingAddressDto saveAddress(ShippingAddressDto shippingAddressDto, Integer cId);

    public ShippingAddressDto getAddress(Long addr_Id);

    public List<ShippingAddressDto> getCustomerAddress(Integer cId);

    public boolean deleteAddress(Long addr_Id);

}
