package com.bridgelabz.codinclub.jwt.repository;

import com.bridgelabz.codinclub.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


import java.util.UUID;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,UUID> {

    User findByUsername(String username);
}
