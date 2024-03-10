package com.meritis.meetup.frameworkless.server;

import com.meritis.meetup.frameworkless.bricoshop.HammerController;
import io.javalin.config.JavalinConfig;

import java.util.Collections;
import java.util.List;

public class ControllerFactory {
    public void createAndBindController(JavalinConfig config) {
        HammerController hammerController = new HammerController();
        config.router.apiBuilder(hammerController::routes);
    }
}
