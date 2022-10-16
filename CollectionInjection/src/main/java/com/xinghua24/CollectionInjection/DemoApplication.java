package com.xinghua24.CollectionInjection;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Component
	@AllArgsConstructor
	public class MyCommandLineRunner implements CommandLineRunner {
		private List<Item> items;

		@Override
		public void run(String... args) throws Exception {
			items.forEach(System.out::println);
		}
	}
}
