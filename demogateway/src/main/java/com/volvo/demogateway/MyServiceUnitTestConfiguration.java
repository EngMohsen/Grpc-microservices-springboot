package com.volvo.demogateway;

import com.volvo.demogateway.service.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServiceUnitTestConfiguration {

    @Bean
    HelloWorldService helloWorldService() {
        return new HelloWorldService();
    }
}
