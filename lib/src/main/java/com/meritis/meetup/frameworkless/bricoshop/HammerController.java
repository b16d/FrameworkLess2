package com.meritis.meetup.frameworkless.bricoshop;

import com.meritis.meetup.frameworkless.server.Controller;
import io.javalin.http.Context;

import static io.javalin.apibuilder.ApiBuilder.*;

public class HammerController implements Controller {
    public void routes() {
        get("/helloworld", this::helloworld);
    }

    public void helloworld(Context ctx) {
        ctx.result("helloworld").status(200);
    }
}
