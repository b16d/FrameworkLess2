package com.meritis.meetup.frameworkless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication
public class HammerApplication {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        SpringApplication.run(HammerApplication.class);
        LocalDateTime fin = LocalDateTime.now();
        System.out.println("Temps démarrage : " + Duration.between(now, fin).toMillis() + "ms");
    }
}
