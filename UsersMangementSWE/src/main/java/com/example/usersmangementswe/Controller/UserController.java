package com.example.usersmangementswe.Controller;

import com.example.usersmangementswe.Exception.ApiException;
import com.example.usersmangementswe.Model.User;
import com.example.usersmangementswe.Service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/api/v1/usersManegment")

public class UserController {
    final private UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> users = userService.getUser();
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors error){
//        if(error.hasErrors()){
//            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
//        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user, Errors error, @PathVariable Integer id) {
//        if (error.hasErrors()) {
//            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
//        }
        boolean isValid = userService.updateUser(id, user);
        if (isValid) {
            return ResponseEntity.status(200).body("user is updated ");
        }
       // return ResponseEntity.status(400).body("Id is not found");
        
            throw new ApiException("Id not Found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        boolean isValid = userService.deleteUser(id);
        if(isValid){
            return ResponseEntity.status(200).body("user is deleted ");
        }
       // return ResponseEntity.status(400).body("Id is not found");
           // no more errors of 400
            throw new ApiException("Id not Found");
    }
    @GetMapping("/getByAge/{age}")
    public ResponseEntity getByAge(@PathVariable Integer age){
        
       List<User> user=userService.findUserByAgeGreaterThanEqual(age);
        return ResponseEntity.status(200).body(user);
    }
    
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        User user=userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/getByRole/{role}")
    public ResponseEntity getByRole(@PathVariable String role){
        List<User>user=userService.findAllByRole(role);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/checkUsernameAndPassword/{username}/{password}")
    public ResponseEntity getByUsernameAndPassword(@PathVariable String username,@PathVariable String password){
        User user=userService.findUserByUsernameAndPasswordAnd(username,password);
        return ResponseEntity.status(200).body(user);

    }
}
