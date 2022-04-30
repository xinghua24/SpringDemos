WebSocket is a computer communications protocol, providing full-duplex communication channels over a single TCP connection.

pom.xml
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-websocket</artifactId>
</dependency>
```

Add @EnableWebSocket annotation to an @Configuration class to configure processing WebSocket requests.

WebSocketConfig.java - register a socket handler.
```java
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SocketTextHandler(), "/user");
    }

}
```

SocketTextHandler.java - a WebSocketHandler that processes text only.
```java
@Component
@Slf4j
public class SocketTextHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        String payload = message.getPayload();
        log.info("receive payload: " + payload);
        JSONObject jsonObject = new JSONObject(payload);
        session.sendMessage(new TextMessage("Hi " + jsonObject.get("user") + " how may we help you?"));
    }

}
```


Reference: 
* [Spring Boot + WebSocket Simple Example](https://www.javainuse.com/spring/boot-websocket)
* [Spring Boot + WebSocket Hello World Example YT Video](https://youtu.be/mv3uS8R-me4)