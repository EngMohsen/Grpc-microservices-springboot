package com.volvo.demogateway.component;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.volvo.demogateway.model.User;
import com.volvo.demogateway.service.HelloWorldService;
import com.volvo.demogateway.service.UserService;
import com.volvo.user.lib.UserRequest;

@Slf4j
@Component
public class UserQuery implements GraphQLQueryResolver {

	@Autowired
	private UserService userService;

	@Autowired
	private HelloWorldService helloWorldService;


	public User getUser(final int id) {
		log.info("get User by Id {} - start",id);
		UserRequest request = userService.getUserById(id);
		log.info("get User by Id response {}",request);
		User user = new User();
		if(request != null) {
			log.info("user is found and exists in db ");
			user.setAddress(request.getAddress());
			user.setAge(request.getAge());
			user.setEmail(request.getEmail());
			user.setFirstName(request.getFirstName());
			user.setPassword(request.getPassword());
			user.setSureName(request.getSureName());
			user.setUserName(request.getUserName());
		}else
			log.error("user not found in the DB");
		return user;
	}

	public String getHello(String name) {
		log.info("getHello, name {} - start",name);
		return helloWorldService.receiveGreeting(name);
	}

}
