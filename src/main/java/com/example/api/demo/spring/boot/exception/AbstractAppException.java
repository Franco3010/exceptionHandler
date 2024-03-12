package com.example.api.demo.spring.boot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractAppException extends RuntimeException {

    private final HttpStatus httpStatus;

    public AbstractAppException(String message, HttpStatus httpStatus) {
        super(message);


        this.httpStatus = httpStatus;
    }
}
