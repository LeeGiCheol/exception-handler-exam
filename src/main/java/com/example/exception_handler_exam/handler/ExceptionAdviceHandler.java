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

@RestControllerAdvice
public class ExceptionAdviceHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> methodValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        ExceptionResponse exceptionResponse = makeErrorResponse(e.getBindingResult());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    private ExceptionResponse makeErrorResponse(BindingResult bindingResult){
        String code = "";
        String message = "";
        String detail = "";

        if(bindingResult.hasErrors()){
            detail = bindingResult.getFieldError().getDefaultMessage();

            System.out.println(detail);

            String bindResultCode = bindingResult.getFieldError().getCode();

            switch (bindResultCode){
                case "NotNull":
                    code = ExceptionCode.NOT_NULL.getCode();

                    if (detail != null) {
                        message = detail;
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
