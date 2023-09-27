package com.example.webClientDemo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Value("${jsonplaceholder.baseurl}")
	private String jsonplaceholderURL;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * Setup a simple WebClient as Spring Bean.
	 * It is common to setup WebClient as Bean and inject it to a component.
	 * WebClient.Builder is pre-configure for you to use
	 */
	@Bean
	public WebClient simpleWebClient(WebClient.Builder builder) {
		return builder.build();
	}

	@Bean
	public WebClient jsonPlaceholderWebClient(WebClient.Builder builder) {
		return builder.baseUrl(jsonplaceholderURL).build();
	}

	@Bean
	public CommandLineRunner run(@Qualifier("simpleWebClient") WebClient webClient,
			@Qualifier("jsonPlaceholderWebClient") WebClient jsonPlaceholderWebClient) {
		return (args) -> {
			webClientGet();
			webClientGet_bodyToMono();
			webClientGetList();
			webClientGetListBodyOnly();
			webClientGetListAsHashMap();
			webClientPost();
			webClientPut();
			webClientDelete();
			webClientHeaders();
			webClient_HandleException();
			webClientCustomizeObjectMapper();
			webClientPassedAsBean(webClient);
			jsonWebClientPassedAsBean(jsonPlaceholderWebClient);
		};
	}


	public static void webClientGet() {
		System.out.println("DemoApplication.webClientGet");
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

	public static void webClientGet_bodyToMono() {
		System.out.println("DemoApplication.webClientGet_bodyToMono");
		WebClient webClient = WebClient.builder()
				.build();
		Todo todo = webClient
				.get()
				.uri("https://jsonplaceholder.typicode.com/todos/2")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Todo.class)
				.block();
		System.out.println(todo);
	}

	public static void webClientGetList() {
		System.out.println("DemoApplication.webClientGetList");
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

	public static void webClientGetListBodyOnly() {
		System.out.println("DemoApplication.webClientGetListBodyOnly");
		WebClient webClient = WebClient.builder()
				.build();
		List<Todo> todos = webClient
				.get()
				.uri("https://jsonplaceholder.typicode.com/todos")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(List.class)
				.block();
		System.out.println(todos
				.stream()
				.toList());
	}

	public static void webClientGetListAsHashMap() {
		System.out.println("DemoApplication.webClientGetListAsHashMap");
		WebClient webClient = WebClient.builder()
				.build();
		List<HashMap<String, String>> todos = webClient
				.get()
				.uri("https://jsonplaceholder.typicode.com/todos")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(List.class)
				.block();
		System.out.println(todos);
	}

	public static void webClientPost() {
		System.out.println("DemoApplication.webClientPost");
		WebClient webClient = WebClient.builder()
				.build();
		Todo newTodo = new Todo().setId(1).setUserId(2).setTitle("Laundry");
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

	public static void webClientPut() {
		System.out.println("DemoApplication.webClientPut");
		WebClient webClient = WebClient.builder()
				.build();
		Todo updatedPost = new Todo().setId(1).setUserId(2).setTitle("Laundry");
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

	public static void webClientDelete() {
		System.out.println("DemoApplication.webClientDelete");
		WebClient webClient = WebClient.builder()
				.build();
		Todo updatedPost = new Todo().setId(1).setUserId(2).setTitle("Laundry");
		ResponseEntity<Void> response = webClient
				.delete()
				.uri("https://jsonplaceholder.typicode.com/posts/1")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.toEntity(Void.class)
				.block();
		System.out.println(response.getStatusCode().value());
	}

	public static void webClientHeaders() {
		System.out.println("DemoApplication.webClientHeaders");
		WebClient webClient = WebClient.builder()
				.build();
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("header1", "header1 value");
		headers.add("header2", "header2 value");
		Todo todo = webClient
				.get()
				.uri("https://jsonplaceholder.typicode.com/todos/2")
				.accept(MediaType.APPLICATION_JSON)
				.header("header1", "header1 value")
				.headers(h -> h.addAll(headers))
				.retrieve()
				.bodyToMono(Todo.class)
				.block();
		System.out.println(todo);
	}

	public static void webClient_HandleException() {
		System.out.println("DemoApplication.webClient_HandleException");
		WebClient webClient = WebClient.builder()
				.build();
		try {
			ResponseEntity<Todo> response = webClient
					.get()
					.uri("https://jsonplaceholder.typicode.com/error")
					.accept(MediaType.APPLICATION_JSON)
					.retrieve()
					.toEntity(Todo.class)
					.block();
			System.out.println(response.getStatusCode().value());
			System.out.println(response.getBody());
		} catch (WebClientException e) {
			System.out.println("Caught WebClientException calling HTTP service");
		} catch (Exception e) {
			System.out.println("Caught Exception calling HTTP service");
		}
	}

	// see
	// https://stackoverflow.com/questions/43769301/how-to-customize-springwebflux-webclient-json-deserialization
	public static void webClientCustomizeObjectMapper() {
		System.out.println("DemoApplication.webClientCustomizeObjectMapper");
		ExchangeStrategies strategies = ExchangeStrategies.builder()
				.codecs(clientDefaultCodecsConfigurer -> {
					ObjectMapper mapper = new ObjectMapper();
					mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
					clientDefaultCodecsConfigurer.defaultCodecs()
							.jackson2JsonEncoder(new Jackson2JsonEncoder(mapper, MediaType.APPLICATION_JSON));
					clientDefaultCodecsConfigurer.defaultCodecs()
							.jackson2JsonDecoder(new Jackson2JsonDecoder(mapper, MediaType.APPLICATION_JSON));
				}).build();
		WebClient webClient = WebClient.builder()
				.exchangeStrategies(strategies)
				.build();
		List<Todo> response = webClient
				.get()
				.uri("https://jsonplaceholder.typicode.com/todos")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(Todo.class)
				.collectList()
				.block();
		System.out.println(response);
	}


	private void webClientPassedAsBean(WebClient webClient) {
		System.out.println("DemoApplication.webClientPassedAsBean");
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

	private void jsonWebClientPassedAsBean(WebClient webClient) {
		System.out.println("DemoApplication.jsonWebClientPassedAsBean");
		ResponseEntity<Todo> response = webClient
				.get()
				.uri("/todos/1")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.toEntity(Todo.class)
				.block();
		System.out.println(response.getStatusCode().value());
		System.out.println(response.getBody());
	}

}