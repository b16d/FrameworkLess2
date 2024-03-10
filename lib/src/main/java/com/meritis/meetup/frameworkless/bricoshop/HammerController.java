package com.meritis.meetup.frameworkless.bricoshop;

import com.meritis.meetup.frameworkless.bricoshop.service.HammerService;
import com.meritis.meetup.frameworkless.bricoshop.service.model.HammerId;
import com.meritis.meetup.frameworkless.hammer.record.Hammer;
import com.meritis.meetup.frameworkless.server.Controller;
import io.javalin.http.Context;

import java.util.UUID;

import static io.javalin.apibuilder.ApiBuilder.*;

public class HammerController implements Controller {
    private final HammerService hammerService;

    public HammerController(HammerService hammerService) {
        this.hammerService = hammerService;
    }

    public void routes() {
        get("/helloworld", this::helloworld);
        get("/hammer/{id}", this::retrieveHammer);
    }

    public void helloworld(Context ctx) {
        ctx.result("HelloWorld !").status(200);
    }

    public void retrieveHammer(Context ctx) {
        Hammer hammer = hammerService.retrieveById(ctx.pathParamAsClass("id", HammerId.class).get());
        ctx.json(hammer).status(200);

    }
}
