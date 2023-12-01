package com.uit.cinemaportalapi.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String  username;
    private String  password;
    private String  email;
    private String  passwordConfirm;
}
