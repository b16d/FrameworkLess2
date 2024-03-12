package com.meritis.meetup.frameworkless;

import com.meritis.meetup.frameworkless.server.ControllerFactory;
import io.javalin.Javalin;

public class HammerApplication {
    public static void main(String[] args) {
        Javalin.create(new ControllerFactory()::createAndBindController)
               .start(8081);
    }
}
