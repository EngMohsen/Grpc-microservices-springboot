package com.volvo.demogateway.service;

import com.volvo.user.lib.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.volvo.demogateway.model.User;
import com.volvo.user.lib.UserIdRequest;
import com.volvo.user.lib.UserRequest;
import com.volvo.user.lib.UserServiceGrpc.UserServiceBlockingStub;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Slf4j
@Service
public class UserService {
	
	@GrpcClient("userService")
	private UserServiceBlockingStub userServiceBlockingStub;
	
	public String login(String userName,int password) {
		UserRequest request = UserRequest.newBuilder()
                .setUserName(userName)
                .setPassword(password)
                .build();
        return userServiceBlockingStub.login(request).getMessage();
    }
	
	public String logout(String userName) {
		UserRequest request = UserRequest.newBuilder()
                .setUserName(userName)
                .build();
        return userServiceBlockingStub.logout(request).getMessage();
    }

	public UserResponse register(User user) {
		log.info("register user {}-start",user);
		UserRequest request = UserRequest.newBuilder()
                .setUserName(user.getUserName())
                .setPassword(user.getPassword())
                .setAddress(user.getAddress())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setSureName(user.getSureName())
                .setAge(user.getAge())
                .build();
		log.info("building user request for registration - {} ",request);
		 return userServiceBlockingStub.register(request);
	}
	
	
	public UserRequest getUserById(int Id) {
		log.info("getUserById {}-start",Id);
		UserIdRequest request = UserIdRequest.newBuilder()
                .setId(Id)
                .build();
		log.info("retrieving user by Id - {} ",request);
		 return userServiceBlockingStub.getUserById(request);
	}

}
