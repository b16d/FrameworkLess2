package com.meritis.meetup.frameworkless.bricoshop.service.model;

import java.util.UUID;

public record HammerTradeMarkId(UUID id) {
    public static HammerTradeMarkId fromString(String id) {
        return new HammerTradeMarkId(UUID.fromString(id));
    }
}
