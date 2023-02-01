package com.example.usersmangementswe.Exception;

public class ApiException extends RuntimeException  {
    //هنا وراثه من كلاس الاكسبشنز عشان نهندل كل الايرورز
    public ApiException(String message){
        super(message);
    }

}
