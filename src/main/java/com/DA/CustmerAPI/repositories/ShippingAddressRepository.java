package com.DA.CustmerAPI.repositories;

import com.DA.CustmerAPI.DTO.CustomerDto;
import com.DA.CustmerAPI.DTO.ShippingAddressDto;
import com.DA.CustmerAPI.entities.ShippingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddressEntity, Long> {

    public ShippingAddressDto saveAddress();
    public ShippingAddressDto getAddress(Long addr_Id);
    public void deleteAddress(Long addr_Id);

    public CustomerDto getAllCustomerByCustomerId(Integer cId);


}
