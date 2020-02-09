package com.example.demo.common.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class APIException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;
    private String message;
    private Map<String, Object> reqParam;

    public APIException() {}

    public APIException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public APIException(String code, String message, Map<String, Object> reqParam){
        super(message);
        this.code = code;
        this.message = message;
        this.reqParam = reqParam;
    }

}
