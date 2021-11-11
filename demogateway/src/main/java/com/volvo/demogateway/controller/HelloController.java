package com.volvo.demogateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.volvo.demogateway.service.HelloWorldService;

@Slf4j
@RestController
public class HelloController {

	@Autowired
	private HelloWorldService helloService;
	
	@GetMapping("hello/{userName}")
	public String helloWorld(@PathVariable String userName) {
		log.info("hello world called with username {}",userName);
		String greeting = helloService.receiveGreeting(userName);
		log.info("hello world response {}",greeting);
		return greeting;
	}
}
