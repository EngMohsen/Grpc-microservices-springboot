package com.volvo.UserRegisteration.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;

import com.volvo.user.lib.UserIdRequest;
import com.volvo.user.lib.UserRequest;
import com.volvo.user.lib.UserResponse;
import com.volvo.user.lib.UserServiceGrpc.UserServiceImplBase;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class UserServiceImp extends UserServiceImplBase {

	private static Map<Integer, UserRequest> USERS = new HashMap<>();

	@Override
	public void getUserById(UserIdRequest request, StreamObserver<UserRequest> responseObserver) {
		// TODO Auto-generated method stub
		log.info("getUserById , request {}- Start",request);
		UserRequest userRequest = null;
		if(USERS.containsKey(request.getId())) {
			log.debug("user {} found ",request.getId());
			userRequest = 	UserRequest.newBuilder(USERS.get(request.getId())).build(); 
		}else{
			log.error("user {} not exists",request.getId());
		}
		responseObserver.onNext(userRequest);
		responseObserver.onCompleted();
		log.info("getUserById, response {} - end",userRequest);
	}
	
	
	

	@Override
	public void register(UserRequest request, StreamObserver<UserResponse> responseObserver) {
		// TODO Auto-generated method stub
		log.info("register, request {}  -start",request);
		UserResponse userResponse = null;
		if (Objects.nonNull(request) && !USERS.containsValue(request)) {
			USERS.put(USERS.size() + 1, request);
			userResponse = UserResponse.newBuilder()
					.setMessage("User is successfully registered")
					.setCode(200).build();
			log.info("User is registered successfully");
		} else {
			userResponse = UserResponse.newBuilder()
					.setMessage("User is already exists. please try different username.")
					.setCode(404).build();
			log.error("User is already registered");
		}
		responseObserver.onNext(userResponse);
		responseObserver.onCompleted();
		log.info("register, response{} - end",userResponse);
	}

	

	@Override
	public void login(UserRequest request, StreamObserver<UserResponse> responseObserver) {
		log.info("login, request {}  -start",request);
		UserResponse userResponse = null;
		Optional<Entry<Integer, UserRequest>> userLogin = USERS.entrySet().stream()
				.filter(user -> user.getValue().getUserName().equals(request.getUserName())
						&& user.getValue().getPassword() == request.getPassword())
				.findFirst();
		if (!userLogin.isEmpty()) {
			log.debug("user {} is found and successfully logged in", request.getUserName());
			userResponse = UserResponse.newBuilder()
					.setMessage("user is successfully login")
					.setCode(200).build();
		} else {
			log.error("login fail for user {}. User not exists", request.getUserName());
			userResponse = UserResponse.newBuilder()
					.setMessage("User not found. please try with different user.")
					.setCode(404).build();
		}
		responseObserver.onNext(userResponse);
		responseObserver.onCompleted();
		log.info("login, response{} -end",userResponse);
	}

	@Override
	public void logout(UserRequest request, StreamObserver<UserResponse> responseObserver) {
		log.info("logout, request {}  -start",request);
		UserResponse userResponse = null;
		Optional<Entry<Integer, UserRequest>> logUser = USERS.entrySet().stream()
				.filter(user -> user.getValue().getUserName().equals(request.getUserName()))
				.findFirst();
		if(logUser.isPresent()) {
			USERS.remove(logUser.get().getKey());
			userResponse = UserResponse.newBuilder()
					.setMessage("User logged out successfully")
					.setCode(200).build();
		}else {
			userResponse = UserResponse.newBuilder()
					.setMessage("User not found")
					.setCode(404).build();
		}
		
		responseObserver.onNext(userResponse);
		responseObserver.onCompleted();
		log.info("logout, response {}  -end",userResponse);
	}

}
