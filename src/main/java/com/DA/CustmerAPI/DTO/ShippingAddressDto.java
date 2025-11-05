package com.DA.CustmerAPI.DTO;

import lombok.Data;

@Data
public class ShippingAddressDto {

    private Long addr_Id;
    private String house_num;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String addType;
    private String deleteSw;
    private Integer cId;

}
