package com.aimerrhythms.springcloud.springcloudconsumer02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringcloudConsumer02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConsumer02Application.class, args);
	}

}
