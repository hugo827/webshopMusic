package com.example.webshopmusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WebshopMusicApplication {

    public static void main(String[] args) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String p = b.encode("password");
        System.out.println(p);
        SpringApplication.run(WebshopMusicApplication.class, args);
    }

}
