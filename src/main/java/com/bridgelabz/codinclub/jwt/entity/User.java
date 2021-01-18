package com.bridgelabz.codinclub.jwt.entity;

import com.bridgelabz.codinclub.jwt.dto.AddUserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "USERNAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    private LocalDateTime createdTimeStamp=LocalDateTime.now();

    public User(AddUserDto addUserDto) {
        this.username=addUserDto.name;
        this.email=addUserDto.email;
        this.password=addUserDto.password;
    }
}
