package com.meritis.meetup.frameworkless.bricoshop;

import com.meritis.meetup.frameworkless.bricoshop.service.HammerService;
import com.meritis.meetup.frameworkless.bricoshop.service.HammerTradeMarkService;
import com.meritis.meetup.frameworkless.hammer.lombok.data.Hammer;
import com.meritis.meetup.frameworkless.hammer.lombok.data.HammerTradeMark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class HammerController {

    private final HammerService hammerService;

    private final HammerTradeMarkService hammerTradeMarkService;

    @Autowired
    public HammerController(HammerService hammerService, HammerTradeMarkService hammerTradeMarkService) {
        this.hammerService = hammerService;
        this.hammerTradeMarkService = hammerTradeMarkService;
    }

    @GetMapping("/helloworld")
    public ResponseEntity<String> helloworld() {
        return ResponseEntity.ok("HelloWorld");
    }

    @GetMapping("/hammer/{id}")
    public ResponseEntity<Hammer> getHammer(@PathVariable(value = "id") UUID id) {
        Hammer hammer = hammerService.retrieveById(id);
        return ResponseEntity.ok(hammer);
    }

    @GetMapping("/tradeMark/{id}/hammers")
    public ResponseEntity<HammerTradeMark> getHammers(@PathVariable(value = "id") UUID tradeMarkId) {
        HammerTradeMark hammerTradeMark = hammerTradeMarkService.retrieveTradeMarkHammer(tradeMarkId);
        return ResponseEntity.ok(hammerTradeMark);
    }
}
