package com.bridgelabz.codinclub.controller;

import com.bridgelabz.codinclub.dto.AddUserDto;
import com.bridgelabz.codinclub.entity.User;
import com.bridgelabz.codinclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codinclub/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    public User addUser(@RequestBody AddUserDto addUserDto){
        User user=new User();
        user.setPassword(
                bCryptPasswordEncoder.encode(user.getPassword())
        );
        user.setEmail(addUserDto.email);
        user.setName(addUserDto.name);
        return userService.addUserToSystem(addUserDto);
    }

    @PostMapping("/login")
    public String authenicateUser(@RequestBody AddUserDto addUserDto){

        return "User Authenicate Successfully.";
    }

}
