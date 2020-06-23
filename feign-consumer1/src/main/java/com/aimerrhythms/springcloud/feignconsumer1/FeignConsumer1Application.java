package com.aimerrhythms.springcloud.feignconsumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumer1Application.class, args);
	}

}
