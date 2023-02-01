package com.example.usersmangementswe.Service;

import com.example.usersmangementswe.Exception.ApiException;
import com.example.usersmangementswe.Model.User;
import com.example.usersmangementswe.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user) {
        User oldUser = userRepository.getById(id);

        if (!userRepository.existsById(id)) {
            return false;
        }
        oldUser.setUsername(user.getUsername());
        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());

        userRepository.save(oldUser);
        return true;
    }

    public boolean deleteUser(Integer id) {
        User user = userRepository.getById(id);
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }
    public User findUserByAge(Integer age){
        //2 نجي هنا نسوي ميثود من نوع الاوبجكت ونرسل لها نفس الهيدر ونعرف متغير
        User user=userRepository.findUserByAge(age);
        // if not found
        if(user==null){
            throw new ApiException("age not found");
        }
        return user;
    }
    //#2
    //------------------------------------
    public User findUserByEmail(String email){
        User user=userRepository.findUserByEmail(email);
        if(user==null) {
            throw new ApiException("Email not found");
        }
        return user;
    }
    public User findUserByUsernameAndPasswordAnd(String username, String password){
        User user = userRepository.findUserByUsernameAndPasswordAnd(username,password);
        if (user==null){
            throw new ApiException("user not found");
        }
        return user;
    }
    public  List<User> findUserByAgeGreaterThanEqual(Integer age){
        List<User> users = userRepository.findUserByAgeGreaterThanEqual(age);
        if (users.isEmpty()){
            throw new ApiException("age not found");
        }
        return users;
    }
    public List<User> findAllByRole(String role){
        List<User> users = userRepository.findAllByRole(role);
        if (users.isEmpty()){
            throw new ApiException("role not found");
        }
        return users;
    }


}
