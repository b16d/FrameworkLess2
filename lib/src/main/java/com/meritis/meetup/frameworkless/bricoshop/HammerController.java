package com.meritis.meetup.frameworkless.bricoshop;

import com.meritis.meetup.frameworkless.bricoshop.service.HammerService;
import com.meritis.meetup.frameworkless.bricoshop.service.HammerTradeMarkService;
import com.meritis.meetup.frameworkless.bricoshop.service.model.HammerId;
import com.meritis.meetup.frameworkless.bricoshop.service.model.HammerTradeMarkId;
import com.meritis.meetup.frameworkless.hammer.record.Hammer;
import com.meritis.meetup.frameworkless.hammer.record.HammerTradeMark;
import com.meritis.meetup.frameworkless.server.Controller;
import io.javalin.http.Context;

import java.util.UUID;

import static io.javalin.apibuilder.ApiBuilder.*;

public class HammerController implements Controller {
    private final HammerService hammerService;
    private final HammerTradeMarkService hammerTradeMarkService;

    public HammerController(HammerService hammerService, HammerTradeMarkService hammerTradeMarkService) {
        this.hammerService = hammerService;
        this.hammerTradeMarkService = hammerTradeMarkService;
    }

    public void routes() {
        get("/helloworld", this::helloworld);
        get("/hammer/{id}", this::retrieveHammer);
        get("/tradeMark/{id}/hammers", this::retrieveHammerTradeMark);
    }

    public void helloworld(Context ctx) {
        ctx.result("HelloWorld !").status(200);
    }

    public void retrieveHammer(Context ctx) {
        Hammer hammer = hammerService.retrieveById(ctx.pathParamAsClass("id", HammerId.class).get());
        ctx.json(hammer).status(200);
    }

    public void retrieveHammerTradeMark(Context ctx) {
        HammerTradeMark tradeMark = hammerTradeMarkService.retrieveTradeMarkHammer(ctx.pathParamAsClass("id", HammerTradeMarkId.class).get());
        ctx.json(tradeMark).status(200);
    }
}
