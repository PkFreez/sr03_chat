package fr.utc.sr03.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //indicates that this is a spring boot application. Enables spring boot's auto-configuration
public class ChatApplication {
    public static void main(String[] args) { //entry point of the application.
        SpringApplication.run(ChatApplication.class, args); //bootstraps the spring context and starts the app
    }
}
