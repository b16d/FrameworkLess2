package com.meritis.meetup.frameworkless;

import io.javalin.Javalin;

public class HammerApplication {
    public static void main(String[] args) {
        Javalin.create()
               .get("helloworld", ctx -> ctx.result("HelloWorld !").status(200))
               .start(8081);
    }
}
