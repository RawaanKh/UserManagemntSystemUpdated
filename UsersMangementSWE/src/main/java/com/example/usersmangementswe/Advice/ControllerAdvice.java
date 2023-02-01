package com.example.usersmangementswe.Advice;

import com.example.usersmangementswe.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// بعد البريك هنا
@RestControllerAdvice
public class ControllerAdvice { //#3
    @ExceptionHandler(value = ApiException.class)
    //every 400 here
    public ResponseEntity ApiException(ApiException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
              //كل الاحداث اللي ممكن تعطل السيرفر من نوع 400
        //  نحطها هنا ونفصلها عن200
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
       public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        String message=e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }


}
