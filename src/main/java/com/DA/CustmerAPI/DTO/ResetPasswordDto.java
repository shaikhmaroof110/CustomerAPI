package com.DA.CustmerAPI.DTO;

import lombok.Data;

@Data
public class ResetPasswordDto {

    private String email;
    private String newPassword;
    private String confirmedPassword;

}
