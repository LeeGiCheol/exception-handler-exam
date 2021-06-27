package com.example.exception_handler_exam.error;

public enum ExceptionCode {
    SYSTEM_ERROR("1111", "시스템에러입니다."),
    NOT_NULL("2222", "필수 파라미터입니다."),
    OVER_LENGTH("3333", "길이를 초과했습니다.")
    ;


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
