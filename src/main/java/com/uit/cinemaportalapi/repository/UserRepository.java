package com.uit.cinemaportalapi.repository;

import com.uit.cinemaportalapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User ,Long > {

}
