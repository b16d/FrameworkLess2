package com.meritis.meetup.frameworkless.server;

import com.meritis.meetup.frameworkless.bricoshop.HammerController;
import com.meritis.meetup.frameworkless.bricoshop.dao.HammerDao;
import com.meritis.meetup.frameworkless.bricoshop.service.HammerService;
import com.meritis.meetup.frameworkless.bricoshop.service.model.HammerId;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import org.jdbi.v3.core.Jdbi;

public class ControllerFactory {
    public void createAndBindController(JavalinConfig config) {
        Jdbi jdbi = new JdbiConfiguration().createJdbi();
        HammerDao hammerDao = new HammerDao(jdbi);
        HammerService hammerService = new HammerService(hammerDao);
        HammerController hammerController = new HammerController(hammerService);
        config.validation.register(HammerId.class, HammerId::fromString);
        config.router.apiBuilder(hammerController::routes);
    }
}
