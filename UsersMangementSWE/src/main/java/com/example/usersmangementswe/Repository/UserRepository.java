package com.example.usersmangementswe.Repository;

import com.example.usersmangementswe.Model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByAge(Integer age);
// اقدر ارجع اي شي ابيه بس ارسله في الهيدر
//rest controller no 400 erroro noly 200
   User findUserById(Integer id);
   @Query("select u from  User u where u.id=?1")
   User findMyid(Integer id);
   // هذي الطريقه نفس اللي فوق بس تنفع للي يعرفون sql مره
    //#1

    //-----------By username and password-----------
    User findUserByUsernameAndPasswordAnd(String username,String password);
    //------------find by email-------------------------
    User findUserByEmail(String email);
    //------------find by age-------------------------
    List<User> findUserByAgeGreaterThanEqual(Integer age);
    //------------find by role-------------------------
    List<User> findAllByRole(String role);


    /*        {  another way  }               */
    //----------------------------------------------------------------------------
    // @Query("SELECT u from User u where u.age>=?1")
    //List<User> findUserAge(Integer age);

    //@Query("SELECT u from User u where u.role='admin'or u.role='user'")
    // List<User> findUserRole(String role);


}
