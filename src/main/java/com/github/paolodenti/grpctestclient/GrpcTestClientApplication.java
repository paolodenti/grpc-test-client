package com.github.paolodenti.grpctestclient;

import com.github.paolodenti.grpctestclient.service.HelloWorldClient;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class GrpcTestClientApplication implements CommandLineRunner {

	private final HelloWorldClient helloWorldClient;

	public static void main(String[] args) {
		SpringApplication.run(GrpcTestClientApplication.class, args);
	}

	@Override
	public void run(String... args) {
		helloWorldClient.sendHelloWorldRequest();
	}
}
