package com.example.webClientDemo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class TodoService {

    public Todo webClientGet(String baseUrl) {
        WebClient webClient = WebClient.builder()
                .build();
        ResponseEntity<Todo> response = webClient
                .get()
                .uri(baseUrl + "/todos/1")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(Todo.class)
                .block();
        System.out.println(response.getStatusCode().value());
        System.out.println(response.getBody());
        return response.getBody();
    }
}
