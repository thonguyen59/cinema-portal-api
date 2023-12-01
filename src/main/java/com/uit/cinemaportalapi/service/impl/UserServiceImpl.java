package com.uit.cinemaportalapi.service.impl;


import com.uit.cinemaportalapi.entity.User;
import com.uit.cinemaportalapi.payload.dto.UserDTO;
import com.uit.cinemaportalapi.repository.UserRepository;
import com.uit.cinemaportalapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Boolean registerUser(UserDTO dto) {

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (!dto.getPassword().equals(dto.getPasswordConfirm())) {
            throw new RuntimeException("Confirm password doesn't match");
        }

        User newUser = new User();
        newUser.setUsername(dto.getUsername());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser.setEnabled(true);
        newUser.setEmail(dto.getEmail());
        newUser.setCreateDate(new Date());
        userRepository.save(newUser);
        return true;
    }

    @Override
    public Boolean Login(UserDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername());
        if (user == null) {
            throw new RuntimeException("Username doesn't exist");
        }

        if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return true;
        }
        throw new RuntimeException("Incorrect password");
    }


}
