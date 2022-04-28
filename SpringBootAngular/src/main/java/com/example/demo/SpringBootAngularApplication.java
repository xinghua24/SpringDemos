package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringBootAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepo;

	@Bean
	public CommandLineRunner appRunner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Product ipad = new Product();
				ipad.setName("iPad");
				ipad.setPrice(new BigDecimal("500.0"));
				productRepo.save(ipad);

				Product iphone = new Product();
				iphone.setName("iPhone");
				iphone.setPrice(new BigDecimal("1000.0"));
				productRepo.save(iphone);

				Product macbookPro = new Product();
				macbookPro.setName("MacBook Pro");
				macbookPro.setPrice(new BigDecimal("2000.0"));
				productRepo.save(macbookPro);
			}
		};
	}
}
