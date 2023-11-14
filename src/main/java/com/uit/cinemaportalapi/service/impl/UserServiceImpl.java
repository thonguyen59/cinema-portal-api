package com.uit.cinemaportalapi.service.impl;


import com.uit.cinemaportalapi.entity.User;
import com.uit.cinemaportalapi.repository.UserRepository;
import com.uit.cinemaportalapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


}
