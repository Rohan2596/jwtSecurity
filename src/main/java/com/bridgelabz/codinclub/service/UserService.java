package com.bridgelabz.codinclub.service;

import com.bridgelabz.codinclub.dto.AddUserDto;
import com.bridgelabz.codinclub.dto.AuthUserDto;
import com.bridgelabz.codinclub.entity.User;
import com.bridgelabz.codinclub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public User addUserToSystem(AddUserDto addUserDto){
        return   userRepository.save(new User(addUserDto));
    }

    public String authUserFromSystem(AuthUserDto authUserDto){
        return "";
    }
}
