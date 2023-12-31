package com.nanterre.LoveMyPet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan("com.nanterre.LoveMyPet.model")
public class LoveMyPetApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveMyPetApplication.class, args);
	}

}
