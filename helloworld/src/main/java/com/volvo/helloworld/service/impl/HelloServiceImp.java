package com.volvo.helloworld.service.impl;

import com.volvo.hello.lib.HelloReply;
import com.volvo.hello.lib.HelloRequest;
import com.volvo.hello.lib.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService()
public class HelloServiceImp extends HelloServiceImplBase {

	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
		log.info("sayHello, request {} - start",request);
		HelloReply reply = HelloReply.newBuilder().setMessage("Hello : " + request.getName()).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
		log.info("sayHello, response {} - end", reply);
	}

}
