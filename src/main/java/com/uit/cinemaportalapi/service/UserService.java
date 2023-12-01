package com.uit.cinemaportalapi.service;

import com.uit.cinemaportalapi.entity.User;
import com.uit.cinemaportalapi.payload.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    Boolean registerUser(UserDTO dto);

    Boolean Login(UserDTO dto);

}
