package com.aimerrhythms.springcloud.eureka_server_node01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerNode01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerNode01Application.class, args);
	}

}
