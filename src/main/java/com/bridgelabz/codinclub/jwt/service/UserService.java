package com.bridgelabz.codinclub.jwt.service;

import com.bridgelabz.codinclub.jwt.configuration.JwtTokenGeneration;
import com.bridgelabz.codinclub.jwt.dto.AddUserDto;
import com.bridgelabz.codinclub.jwt.dto.AuthUserDto;
import com.bridgelabz.codinclub.jwt.entity.User;
import com.bridgelabz.codinclub.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if(user==null){
            throw  new UsernameNotFoundException("User Not Found with username: " + username);
        }
        return UserDetailsImpl.build(user);
    }
}
