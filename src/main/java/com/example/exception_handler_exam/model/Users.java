package com.example.exception_handler_exam.model;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class Users {

    @NotNull(message = "필수 파라미터입니다.")
    private String username;

    private String a;


}
