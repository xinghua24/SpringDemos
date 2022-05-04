package com.example.stompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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