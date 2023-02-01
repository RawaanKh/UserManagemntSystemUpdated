package com.example.usersmangementswe.Advice;

import com.example.usersmangementswe.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice { //#3
    @ExceptionHandler(value = ApiException.class)
    //every 400 here
    public ResponseEntity ApiException(ApiException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
            
       
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
       public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        String message=e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }


}
