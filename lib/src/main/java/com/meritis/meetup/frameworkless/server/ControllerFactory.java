package com.meritis.meetup.frameworkless.server;

import com.meritis.meetup.frameworkless.bricoshop.HammerController;
import com.meritis.meetup.frameworkless.bricoshop.dao.HammerDao;
import com.meritis.meetup.frameworkless.bricoshop.dao.HammerTradeMarkDao;
import com.meritis.meetup.frameworkless.bricoshop.service.HammerService;
import com.meritis.meetup.frameworkless.bricoshop.service.HammerTradeMarkService;
import com.meritis.meetup.frameworkless.bricoshop.service.model.HammerId;
import com.meritis.meetup.frameworkless.bricoshop.service.model.HammerTradeMarkId;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import org.jdbi.v3.core.Jdbi;

public class ControllerFactory {
    public void createAndBindController(JavalinConfig config) {
        Jdbi jdbi = new JdbiConfiguration().createJdbi();
        HammerDao hammerDao = new HammerDao(jdbi);
        HammerTradeMarkDao hammerTradeMarkDao = new HammerTradeMarkDao(jdbi);
        HammerService hammerService = new HammerService(hammerDao);
        HammerTradeMarkService hammerTradeMarkService = new HammerTradeMarkService(hammerTradeMarkDao);
        HammerController hammerController = new HammerController(hammerService, hammerTradeMarkService);
        config.validation.register(HammerId.class, HammerId::fromString);
        config.validation.register(HammerTradeMarkId.class, HammerTradeMarkId::fromString);
        config.router.apiBuilder(hammerController::routes);
    }
}
