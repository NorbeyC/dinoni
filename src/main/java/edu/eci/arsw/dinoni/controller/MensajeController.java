package edu.eci.arsw.dinoni.controller;


import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.dinoni.model.Mensaje;

@Controller
public class MensajeController {
    
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public Mensaje register(@Payload Mensaje chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
        if(sessionAttributes != null) {
            sessionAttributes.put("username", chatMessage.getSender());
        }
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Mensaje sendMessage(@Payload Mensaje chatMessage) {
        return chatMessage;
    }
}
