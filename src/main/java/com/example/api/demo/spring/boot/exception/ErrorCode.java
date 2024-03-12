package com.example.api.demo.spring.boot.exception;

import lombok.Getter;
import lombok.Setter;

@Getter

public enum ErrorCode {
    USER_NOT_EXISTED(1001,"User not existed!")
    ;
    private Integer code;
    private String message;

    ErrorCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

}
