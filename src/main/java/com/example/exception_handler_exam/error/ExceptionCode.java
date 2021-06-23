package com.example.exception_handler_exam.error;

public enum ExceptionCode {
    SYSTEM_ERROR("1111", "시스템에러");

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

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
