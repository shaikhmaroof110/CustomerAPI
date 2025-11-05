package com.DA.CustmerAPI.service;

import com.DA.CustmerAPI.DTO.ShippingAddressDto;
import com.DA.CustmerAPI.entities.CustomerEntity;
import com.DA.CustmerAPI.entities.ShippingAddressEntity;
import com.DA.CustmerAPI.mapper.ShippingAddressMapper;
import com.DA.CustmerAPI.repositories.CustomerRepository;
import com.DA.CustmerAPI.repositories.ShippingAddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService{

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ShippingAddressDto saveAddress(ShippingAddressDto shippingAddressDto, Integer cId) {
// Finding customer by using customer Id
        CustomerEntity customerEntity = customerRepository.findById(cId).orElseThrow();
        // shippingAddressDto converting it to entity and setting data
        ShippingAddressEntity shippingAddressEntity = ShippingAddressMapper.convertToEntity(shippingAddressDto);
        shippingAddressEntity.setCustomer(customerEntity);
        shippingAddressEntity.setDeleteSw("N");
        // saving the data
        ShippingAddressEntity addressEntity = shippingAddressRepository.save(shippingAddressEntity);
        //Again converting into DTO and then returning it.
        return ShippingAddressMapper.convertToDto(addressEntity);
    }

    @Override
    public ShippingAddressDto getAddress(Long addr_Id) {
        Optional<ShippingAddressEntity> addressEntity = shippingAddressRepository.findById(addr_Id);
        if(addressEntity.isPresent())
        {
            return ShippingAddressMapper.convertToDto(addressEntity.get());
        }
        return null;
    }


    @Override
    public List<ShippingAddressDto> getCustomerAddress(Integer cId) {

        List<ShippingAddressEntity> addressEntityList = shippingAddressRepository.findByCustomerCustomerIdAndDeleteSw(cId, "N");
        return addressEntityList.stream()
                .map(ShippingAddressMapper::convertToDto)
                .toList();
    }

    @Override
    public boolean deleteAddress(Long addr_Id) {
        Optional<ShippingAddressEntity> addressEntity = shippingAddressRepository.findById(addr_Id);
        if(addressEntity.isPresent())
        {
            ShippingAddressEntity shippingAddressEntity = addressEntity.get();
            shippingAddressEntity.setDeleteSw("Y");
            shippingAddressRepository.save(shippingAddressEntity);
            return true;
        }
        return false;
    }
}
