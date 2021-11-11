package com.volvo.demogateway.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.volvo.hello.lib.HelloRequest;
import com.volvo.hello.lib.HelloServiceGrpc.HelloServiceBlockingStub;

import net.devh.boot.grpc.client.inject.GrpcClient;


@Slf4j
@Service
public class HelloWorldService {
	
	@GrpcClient("helloService")
	private HelloServiceBlockingStub helloServiceBlockingStub;
	
	public String receiveGreeting(String name) {
        log.info("receiveGreeting {} -start", name);
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        log.info("building hello request {}", request);
        return helloServiceBlockingStub.sayHello(request).getMessage();
    }
}
