package com.vlad.flowerstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlowerStoreApplication {

	private static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(FlowerStoreApplication.class, args);
	}

}
