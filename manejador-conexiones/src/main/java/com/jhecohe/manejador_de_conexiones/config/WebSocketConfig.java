package com.jhecohe.manejador_de_conexiones.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        
        // Prefix for broadcasting messages
        config.enableSimpleBroker("/topic"); 
        // Prefix for client-to-server communication
        config.setApplicationDestinationPrefixes("/app");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("ws") // This a WebSocket endpoint
        .setAllowedOrigins("http://localhost:80")
        // .setAllowedOrigins("http://localhost:63342") // Allow frontend origin
        .withSockJS(); // Enable SockJS for fallback support // fallback -> Alternativa
    }

    
    
}
