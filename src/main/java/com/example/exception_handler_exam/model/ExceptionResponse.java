package com.example.exception_handler_exam.model;

public class ExceptionResponse {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionResponse() {}

    public ExceptionResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
