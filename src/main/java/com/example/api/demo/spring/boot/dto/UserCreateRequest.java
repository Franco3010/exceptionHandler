package com.example.api.demo.spring.boot.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class UserCreateRequest {
    public String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;

}
