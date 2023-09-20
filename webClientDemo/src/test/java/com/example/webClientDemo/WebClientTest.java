package com.example.webClientDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.IOException;

public class WebClientTest {
    public static MockWebServer mockBackEnd;
    private String url;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void initialize() {
        url = String.format("http://localhost:%d",
                mockBackEnd.getPort());
    }

    @Test
    void testGet() throws JsonProcessingException {
        Todo mockTodo = new Todo()
                .setId(1)
                .setUserId(2)
                .setTitle("Laundry");
        mockBackEnd.enqueue(new MockResponse()
                .setBody(new ObjectMapper().writeValueAsString(mockTodo))
                .addHeader("Content-Type", "application/json"));
        mockBackEnd.enqueue(new MockResponse()
                .setBody(new ObjectMapper().writeValueAsString(new Todo().setTitle("Homework")))
                .addHeader("Content-Type", "application/json"));

        TodoService service = new TodoService();
        Todo todo = service.webClientGet(url);
        Assertions.assertEquals("Laundry", todo.getTitle());

        todo = service.webClientGet(url);
        Assertions.assertEquals("Homework", todo.getTitle());

    }

    @Test
    void testGetException() throws JsonProcessingException {
        Todo mockTodo = new Todo()
                .setId(1)
                .setUserId(2)
                .setTitle("Laundry");

        mockBackEnd.enqueue(new MockResponse()
                .setResponseCode(500)
                .setBody("error message")
                .addHeader("Content-Type", "application/json"));

        TodoService service = new TodoService();
        WebClientResponseException webClientResponseException = Assertions.assertThrows(WebClientResponseException.class, () -> service.webClientGet(url));
        Assertions.assertEquals("error message", webClientResponseException.getResponseBodyAsString());

    }
}
