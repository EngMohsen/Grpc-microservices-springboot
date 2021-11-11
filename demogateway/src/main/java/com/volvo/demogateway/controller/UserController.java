package com.volvo.demogateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.volvo.demogateway.model.User;
import com.volvo.demogateway.service.UserService;
import com.volvo.user.lib.UserRequest;

@Slf4j
@RestController
public class UserController {
	
	@Autowired
	private UserService loginService;
	
	@PostMapping(path = "/register",consumes = {"application/json"})
	public String register (@RequestBody User user) {
		log.info("User registration called for user {}",user);
		return loginService.register(user).getMessage();
		
	}
	
	
	@GetMapping("/login")
	public String login (@RequestParam String userName,
			@RequestParam int password) {
		log.info("User login with credential userName{} , password {}",userName,password);
		return loginService.login(userName, password);
		
	}
}
