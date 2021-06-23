package com.example.exception_handler_exam.error;

public class HelloException extends RuntimeException {

    private ExceptionCode code;

    public ExceptionCode getCode() {
        return code;
    }

    public void setCode(ExceptionCode code) {
        this.code = code;
    }

    public HelloException(ExceptionCode code) {
        this.code = code;
    }

}
