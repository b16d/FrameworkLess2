package com.meritis.meetup.frameworkless;

import com.meritis.meetup.frameworkless.server.Controller;
import com.meritis.meetup.frameworkless.server.ControllerFactory;
import io.javalin.Javalin;

import java.time.Duration;
import java.time.LocalDateTime;

public class HammerApplication {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Javalin.create(new ControllerFactory()::createAndBindController)
               .start(8081);
       LocalDateTime fin = LocalDateTime.now();
       System.out.println("Temps démarrage : " + Duration.between(now, fin).toMillis() + "ms");
    }
}
