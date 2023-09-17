package com.example.webClientDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (args) -> {
			webClientGet();
			webClientGetList();
			webClientPost();
			webClientPut();
			webClientDelete();
		};
	}

	private static void webClientGet() {
		WebClient webClient = WebClient.builder()
				.build();
		ResponseEntity<Todo> response = webClient
				.get()
				.uri("https://jsonplaceholder.typicode.com/todos/1")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.toEntity(Todo.class)
				.block();
		System.out.println(response.getStatusCode().value());
		System.out.println(response.getBody());
	}

	private static void webClientGetList() {
		WebClient webClient = WebClient.builder()
				.build();
		ResponseEntity<List<Todo>> response = webClient
				.get()
				.uri("https://jsonplaceholder.typicode.com/todos")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.toEntityList(Todo.class)
				.block();
		System.out.println(response.getStatusCode().value());
		System.out.println(response.getBody()
				.stream()
						.findFirst().get().getUserId());
	}

	private static void webClientPost() {
		WebClient webClient = WebClient.builder()
				.build();
		Todo newTodo = new Todo().setId(1).setUserId(2).setTitle("Laundry").setCompleted(false);
		ResponseEntity<Todo> response = webClient
				.post()
				.uri("https://jsonplaceholder.typicode.com/posts")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.bodyValue(newTodo)
				.retrieve()
				.toEntity(Todo.class)
				.block();
		System.out.println(response.getStatusCode().value());
		System.out.println(response.getBody());
	}

	private static void webClientPut() {
		WebClient webClient = WebClient.builder()
				.build();
		Todo updatedPost = new Todo().setId(1).setUserId(2).setTitle("Laundry").setCompleted(false);
		ResponseEntity<Todo> response = webClient
				.put()
				.uri("https://jsonplaceholder.typicode.com/posts/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.bodyValue(updatedPost)
				.retrieve()
				.toEntity(Todo.class)
				.block();
		System.out.println(response.getStatusCode().value());
		System.out.println(response.getBody());
	}

	private static void webClientDelete() {
		WebClient webClient = WebClient.builder()
				.build();
		Todo updatedPost = new Todo().setId(1).setUserId(2).setTitle("Laundry").setCompleted(false);
		ResponseEntity<Void> response = webClient
				.delete()
				.uri("https://jsonplaceholder.typicode.com/posts/1")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.toEntity(Void.class)
				.block();
		System.out.println(response.getStatusCode().value());
	}
}