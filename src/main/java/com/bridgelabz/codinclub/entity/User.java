package com.bridgelabz.codinclub.entity;

import com.bridgelabz.codinclub.dto.AddUserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;


@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdTimeStamp=LocalDateTime.now();

    public User(AddUserDto addUserDto) {
        this.name=addUserDto.name;
        this.email=addUserDto.email;
        this.password=addUserDto.password;
    }
}
