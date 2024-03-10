package com.meritis.meetup.frameworkless.bricoshop.dao;

import java.util.UUID;

public record HammerEntity(UUID id, String name, int size, int weight) {
}
