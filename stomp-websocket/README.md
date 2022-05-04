Tutorial:
[https://www.dariawan.com/tutorials/spring/spring-boot-websocket-stomp-tutorial/](https://www.dariawan.com/tutorials/spring/spring-boot-websocket-stomp-tutorial/)

WebSocketConfig.java
```java
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * destination with /topic prefix will be handled by embeded STOMP broker
     * destination with /app prefix will be handled by spring controller
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * register stomp endpoint /broadcast.
     * when client send message to /app/broadcast, spring controller will receive the message.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/broadcast");
    }
}
```

WebSocketBroadcastController - controller that receives and broadcasts message
```java
@Controller
public class WebSocketBroadcastController {

    @GetMapping("/stomp-broadcast")
    public String getWebSocketBroadcast() {
        return "stomp-broadcast";
    }

    @MessageMapping("/broadcast") // map messages headed for the /broadcast
    @SendTo("/topic/messages") // return message will be sent to /topic/broadcast destination
    public ChatMessage send(ChatMessage chatMessage) throws Exception {
        System.out.println("send method");
        return new ChatMessage(chatMessage.getFrom(), chatMessage.getText(), "ALL");
    }
}
```
Spring boot STOMP documentation:
[https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/websocket.html#websocket-stomp](https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/websocket.html#websocket-stomp)

More on STOMP with Spring
[WebSockets With Spring, Part 3: STOMP Over WebSocket](https://medium.com/swlh/websockets-with-spring-part-3-stomp-over-websocket-3dab4a21f397)
