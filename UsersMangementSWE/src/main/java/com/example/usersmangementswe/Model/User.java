package com.example.usersmangementswe.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @NotNull(message = "id should not be empty")
    private Integer id;
    @NotEmpty(message = "cannot be empty")
    @Size(min = 4,message = "name must be greater thant 4")
    private String name;
    @NotEmpty(message = "cannot be empty")
    @Size(min = 4,message = "size must be greater thant 4")
   // @Column(columnDefinition = "varchar(15) not null,unique")
    private String username;
    @NotEmpty(message = "cannot be empty")
   // @Column(columnDefinition = "varchar(15) not null")
    private String password;
    @Email(message = "email cannot be empty")
    //@Column(columnDefinition = "varchar(15) unique,not null")
    @NotEmpty(message = "cannot be empty")
    private String email;

   // @Column(columnDefinition = "varchar(5)check (role='user' or role='admin'),not null")
    @NotEmpty(message = "cannot be empty")
    @Pattern(regexp = "^admin|user$",message = "role can be admin or user only")
    private String role;
    @NotNull(message = "cannot be empty")
    //@Column(columnDefinition = "varchar(3) not null")
    private Integer age;
}
