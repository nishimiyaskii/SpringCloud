package com.aimerrhythms.springcloud.springcloudconsumer01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringcloudConsumer01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConsumer01Application.class, args);
	}

}
