package com.mybankingeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MybankingeurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybankingeurekaApplication.class, args);
	}

}
