package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.exmaple.repository")
public class SpringDataMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongoDemoApplication.class, args);
	}

}
