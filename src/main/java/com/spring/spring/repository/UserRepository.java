package com.spring.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

}