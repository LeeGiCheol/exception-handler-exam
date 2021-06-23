package com.example.exception_handler_exam.handler;

import com.example.exception_handler_exam.error.HelloException;
import com.example.exception_handler_exam.model.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceHandler {

    @ExceptionHandler(HelloException.class)
    public ResponseEntity<ExceptionResponse> response(HelloException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setCode(exception.getCode().getCode());
        response.setMessage(exception.getCode().getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> response2(MethodArgumentNotValidException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setCode(exception.getBindingResult().getAllErrors().get(0).getCode());
        response.setMessage(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());

        return ResponseEntity.ok(response);
    }

}
