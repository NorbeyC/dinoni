package edu.eci.arsw.dinoni.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.eci.arsw.dinoni.model.Mensaje;
import edu.eci.arsw.dinoni.model.Usuario;
import edu.eci.arsw.dinoni.service.UsuarioService;

@Controller
public class MensajeController {
    
    @Autowired
    UsuarioService usuarioService;

    /**
     * Metodo que se encarga del registro del usuario al chat
     * @param chatMessage
     * @param headerAccessor
     * @return
     */
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public Mensaje register(@Payload Mensaje chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
        if(sessionAttributes != null) {
            sessionAttributes.put("username", chatMessage.getSender());
        }
        return chatMessage;
    }

    /**
     * Metodo que se encarga de enviar un mensaje
     * @param chatMessage
     * @return
     */
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Mensaje sendMessage(@Payload Mensaje chatMessage) {
        return chatMessage;
    }

    /**
     * Metodo que retorna el ModelAndView del chat
     * @param producto
     * @return
     */
    @GetMapping(value="/tienda/chat",params = "producto")
    public ModelAndView chat(@RequestParam("producto") String producto) {
        ModelAndView mav = new ModelAndView();
        try {
            UserDetails UserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usuario = usuarioService.getUsuarioByNombre(UserDetails.getUsername()).get();
            mav.setViewName("chat");
            mav.addObject("usuario", usuario);
            mav.addObject("producto", producto);
        } catch (Exception e) {
            System.out.println(e);
            mav.setViewName("error");
        }
        return mav;
    }
}
