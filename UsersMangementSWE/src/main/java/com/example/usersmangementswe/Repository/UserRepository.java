package com.example.usersmangementswe.Repository;

import com.example.usersmangementswe.Model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
  
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
   // User findUserByAge(Integer age);

   User findUserById(Integer id);
   @Query("select u from  User u where u.id=?1")
   User findMyid(Integer id);

}
