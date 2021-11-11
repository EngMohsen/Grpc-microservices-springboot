package com.volvo.helloworld;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.volvo.helloworld.service.impl.HelloServiceImp;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
//		Server server  = ServerBuilder.forPort(8080).addService(new HelloServiceImp()).build();
//	
//		try {
//			server.start();
//			server.awaitTermination();
//		} catch (IOException | InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

}
