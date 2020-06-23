package com.aimerrhythms.springcloud.feignprovider;

import org.junit.jupiter.api.Test;

import java.util.Random;

class FeignProviderApplicationTests {

	private Random random = new Random();

	@Test
	void contextLoads() {

		System.out.println((random.nextInt(250) + 500));

	}

}
