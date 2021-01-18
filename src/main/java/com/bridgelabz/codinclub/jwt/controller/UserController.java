package com.bridgelabz.codinclub.jwt.controller;

import com.bridgelabz.codinclub.jwt.configuration.JWTAuthorizationFilter;
import com.bridgelabz.codinclub.jwt.dto.AddUserDto;
import com.bridgelabz.codinclub.jwt.dto.AuthUserDto;
import com.bridgelabz.codinclub.jwt.entity.User;
import com.bridgelabz.codinclub.jwt.repository.UserRepository;
import com.bridgelabz.codinclub.jwt.service.UserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/register")
    public String addUser(@RequestBody AddUserDto addUserDto  ){

        return saveUser(addUserDto);
    }

    public String saveUser(AddUserDto addUserDto){
        addUserDto.password=bCryptPasswordEncoder.encode(addUserDto.password);
        return String.valueOf(userRepository.save(new User(addUserDto)).getId());
    }

    @PostMapping("/login")
    public String authenicateUser(@RequestBody AuthUserDto authUserDto){

        return "";
    }

    @GetMapping("all")
    public User getAllUser(){

        return null;
    }

}
