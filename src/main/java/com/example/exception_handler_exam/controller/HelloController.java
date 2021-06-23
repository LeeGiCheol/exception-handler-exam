package com.example.exception_handler_exam.controller;

import com.example.exception_handler_exam.error.ExceptionCode;
import com.example.exception_handler_exam.error.HelloException;
import com.example.exception_handler_exam.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        throw new HelloException(ExceptionCode.SYSTEM_ERROR);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(@Valid @RequestBody Users user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }
        System.out.println(user.getUsername());
        return ResponseEntity.ok(user.getUsername());
    }


}
