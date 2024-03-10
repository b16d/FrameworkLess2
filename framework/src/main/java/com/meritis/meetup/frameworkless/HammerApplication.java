package com.meritis.meetup.frameworkless;

import com.meritis.meetup.frameworkless.bricoshop.dao.HammerEntity;
import com.meritis.meetup.frameworkless.bricoshop.dao.HammerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.meritis.meetup.frameworkless.bricoshop.dao")
public class HammerApplication {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        ConfigurableApplicationContext run = SpringApplication.run(HammerApplication.class);
        LocalDateTime fin = LocalDateTime.now();
        System.out.println("Temps démarrage : " + Duration.between(now, fin).toMillis() + "ms");
    }
}
