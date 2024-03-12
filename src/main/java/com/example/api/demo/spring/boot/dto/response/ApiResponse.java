package com.example.api.demo.spring.boot.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse <T> {
    private int code = 200;
    private String message = "Sucess";
    private T result;
}
