package com.bridgelabz.codinclub.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDto {
    public String email;
    public String password;
}
