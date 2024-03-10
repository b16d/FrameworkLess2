package com.meritis.meetup.frameworkless.bricoshop.dao;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;

import java.util.UUID;

public class HammerDao {
    private final Jdbi jdbi;

    public HammerDao(Jdbi jdbi) {
        this.jdbi = jdbi;
        jdbi.registerRowMapper(ConstructorMapper.factory(HammerEntity.class));
    }

    public HammerEntity retrieveHammerById(UUID id) {
        return jdbi.withHandle(handle -> handle.createQuery("Select id, name from hammer where id = :id")
                .bind("id", id)
                .mapTo(HammerEntity.class)
                .one());
    }
}
