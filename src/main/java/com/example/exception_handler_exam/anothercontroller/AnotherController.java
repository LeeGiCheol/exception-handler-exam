package com.example.exception_handler_exam.anothercontroller;

import com.example.exception_handler_exam.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AnotherController {

    @GetMapping("/another")
    public ResponseEntity<?> test(@Valid @RequestBody Users user) {
        System.out.println(user.getUsername());
        return ResponseEntity.ok(user.getUsername());
    }

}
