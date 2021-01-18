package com.bridgelabz.codinclub.jwt.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bridgelabz.codinclub.jwt.entity.User;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.bridgelabz.codinclub.jwt.configuration.SecurityConstants.EXPIRATION_TIME;
import static com.bridgelabz.codinclub.jwt.configuration.SecurityConstants.SECRET;

@Component
public class JwtTokenGeneration {

    public String generate(User user){
        String token = JWT.create()
                .withSubject(user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));
return token;
    }
}
