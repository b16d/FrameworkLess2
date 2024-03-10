package com.meritis.meetup.frameworkless.bricoshop.service.model;

import java.util.UUID;

public record HammerId(UUID id) {
    public static HammerId fromString(String id) {
        return new HammerId(UUID.fromString(id));
    }
}
