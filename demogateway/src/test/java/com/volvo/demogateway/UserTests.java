package com.volvo.demogateway;


import com.volvo.demogateway.model.User;
import com.volvo.demogateway.service.HelloWorldService;
import com.volvo.demogateway.service.UserService;
import com.volvo.user.lib.UserResponse;
import com.volvo.user.lib.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
	
//
	@Autowired
	private UserService userService;





	@Before
	public void userRegister() {

        User user = new User("ahmed","mohsen",22,"hello@mail.com"
                ,"gotenbery","amohsen",1234);
        UserResponse response = UserResponse.newBuilder()
                .setMessage("User is successfully registered")
                        .setCode(200)
                        .build();

		when(userService.register(user)).thenReturn(response);
		assertEquals(response, userService.register(user));
	}

    @Test
    public void logout() {
        String message = "User logged out successfully";
        when(userService.logout("amohsen"))
                .thenReturn("User logged out successfully");
        assertEquals(message, userService.logout("amohsen"));
    }
}
