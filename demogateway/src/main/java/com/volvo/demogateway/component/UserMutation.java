package com.volvo.demogateway.component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.volvo.demogateway.model.User;
import com.volvo.demogateway.service.UserService;
import com.volvo.user.lib.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public String registerUser(String firstName,String sureName,int age,String email,String address,String userName,int password ){
        log.info("Register User");
            User user = new User(firstName,sureName,age,email,address,userName,password);
            UserResponse response = userService.register(user);
            if(response.getCode()==200){
                log.info("User registered successfully.");
            }else{
                log.error("Error in user registration.");
            }
            return response.getMessage();
    }
}
