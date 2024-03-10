package com.meritis.meetup.frameworkless.bricoshop.dao;

import com.meritis.meetup.frameworkless.bricoshop.service.model.HammerId;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;

public class HammerDao {
    private final Jdbi jdbi;

    public HammerDao(Jdbi jdbi) {
        this.jdbi = jdbi;
        jdbi.registerRowMapper(ConstructorMapper.factory(HammerEntity.class));
    }

    public HammerEntity retrieveHammerById(HammerId hammerId) {
        return jdbi.withHandle(handle -> handle.createQuery("Select id, name, size, height from hammer where id = :id")
                .bind("id", hammerId.id())
                .mapTo(HammerEntity.class)
                .one());
    }
}
