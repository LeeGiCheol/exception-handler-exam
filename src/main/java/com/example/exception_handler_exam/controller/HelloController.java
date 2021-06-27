package com.example.exception_handler_exam.controller;

import com.example.exception_handler_exam.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HelloController {

    @GetMapping("/test")
    public ResponseEntity<?> test(@Valid @RequestBody Users user) {
        System.out.println(user.getUsername());
        return ResponseEntity.ok(user.getUsername());
    }


}
