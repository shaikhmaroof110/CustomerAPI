package com.DA.CustmerAPI.repositories;

import com.DA.CustmerAPI.DTO.CustomerDto;
import com.DA.CustmerAPI.DTO.ShippingAddressDto;
import com.DA.CustmerAPI.entities.ShippingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddressEntity, Long> {

    // select * from shipping_addr where customer_id = ? and delete_sw=?
    public List<ShippingAddressEntity> findByCustomerCustomerIdAndDeleteSw(Integer customerId, String deleteSw);


}
