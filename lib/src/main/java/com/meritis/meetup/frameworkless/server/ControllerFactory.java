package com.meritis.meetup.frameworkless.server;

import com.meritis.meetup.frameworkless.bricoshop.HammerController;
import com.meritis.meetup.frameworkless.bricoshop.dao.HammerDao;
import com.meritis.meetup.frameworkless.bricoshop.dao.HammerEntity;
import io.javalin.config.JavalinConfig;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ControllerFactory {
    public void createAndBindController(JavalinConfig config) {
        Jdbi jdbi = new JdbiConfiguration().createJdbi();
        HammerDao hammerDao = new HammerDao(jdbi);
        HammerController hammerController = new HammerController();
        config.router.apiBuilder(hammerController::routes);
    }
}
