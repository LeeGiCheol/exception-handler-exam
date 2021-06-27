package com.example.exception_handler_exam.handler;

import com.example.exception_handler_exam.error.ExceptionCode;
import com.example.exception_handler_exam.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice(basePackages = { "com.example.exception_handler_exam.controller" })
public class ExceptionAdviceHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandler(MethodArgumentNotValidException e){
        ExceptionResponse exceptionResponse = makeErrorResponse(e.getBindingResult());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    private ExceptionResponse makeErrorResponse(BindingResult bindingResult){
        String code = "";
        String message = "";
        String defaultMessage = "";

        if(bindingResult.hasErrors()){
            defaultMessage = bindingResult.getFieldError().getDefaultMessage();

            String bindResultCode = bindingResult.getFieldError().getCode();

            switch (bindResultCode){
                case "NotNull":
                    code = ExceptionCode.NOT_NULL.getCode();

                    if (defaultMessage != null) {
                        message = defaultMessage;
                    } else {
                        message = ExceptionCode.NOT_NULL.getMessage();
                    }

                    break;

                case "Length":
                    code = ExceptionCode.OVER_LENGTH.getCode();
                    message = ExceptionCode.OVER_LENGTH.getMessage();
                    break;
            }
        }

        return new ExceptionResponse(code, message);
    }

}
