package com.gatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class APIGatway {
	public static void main(String[] args) {
		SpringApplication.run(APIGatway.class, args);
	}

}
