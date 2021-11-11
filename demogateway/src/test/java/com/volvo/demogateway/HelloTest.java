package com.volvo.demogateway;


import com.volvo.demogateway.service.HelloWorldService;
import com.volvo.demogateway.service.UserService;
import com.volvo.hello.lib.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest()
@SpringJUnitConfig(classes = { MyServiceUnitTestConfiguration.class })
@DirtiesContext
public class HelloTest {

    @Autowired
    private HelloWorldService helloWorldService;

    @GrpcClient("helloService")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    @GrpcClient("inProcess")
    private HelloServiceGrpc.HelloServiceBlockingStub myService;


    @Test
    @DirtiesContext
    public void hello() {
        String message = "Hello : ahmed";
        when(helloWorldService.receiveGreeting(null))
                .thenReturn(null);
        assertEquals(message, helloWorldService.receiveGreeting(null));
    }
}
