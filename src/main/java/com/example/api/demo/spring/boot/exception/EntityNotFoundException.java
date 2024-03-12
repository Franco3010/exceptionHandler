package com.example.api.demo.spring.boot.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class EntityNotFoundException extends RuntimeException {
    private Integer code;
    public EntityNotFoundException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
