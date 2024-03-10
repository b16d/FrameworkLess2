package com.meritis.meetup.frameworkless.bricoshop.dao;

import org.jdbi.v3.core.mapper.reflect.ColumnName;
import org.jdbi.v3.core.mapper.reflect.JdbiConstructor;

import java.util.ArrayList;
import java.util.List;

public record HammerTradeMarkEntity(String tradeMarkName, List<HammerEntity> hammers) {
    @JdbiConstructor
    public HammerTradeMarkEntity(@ColumnName("tradeMarkName") String tradeMarkName) {
        this(tradeMarkName, new ArrayList<>());
    }
}
