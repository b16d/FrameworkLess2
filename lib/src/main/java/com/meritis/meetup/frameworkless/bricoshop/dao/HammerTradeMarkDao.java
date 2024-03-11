package com.meritis.meetup.frameworkless.bricoshop.dao;

import com.meritis.meetup.frameworkless.bricoshop.service.model.HammerTradeMarkId;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.jdbi.v3.core.result.RowView;

import java.util.List;
import java.util.Map;

public class HammerTradeMarkDao {
    private final Jdbi jdbi;

    public HammerTradeMarkDao(Jdbi jdbi) {
        this.jdbi = jdbi;
        jdbi.registerRowMapper(ConstructorMapper.factory(HammerTradeMarkEntity.class));
    }

    public HammerTradeMarkEntity retrieve(HammerTradeMarkId tradeMarkId) {
        return jdbi.withHandle(handle -> handle.createQuery("""
                                                       Select
                                                             tradeMark.trade_mark_name as tradeMarkName,
                                                             hammer.id as id,
                                                             hammer.name as name,
                                                             hammer.weight as weight,
                                                             hammer.size as size
                                                       from trade_mark_hammer tradeMark
                                                       inner join hammer hammer on hammer.trade_mark_id = tradeMark.id
                                                       where tradeMark.id = :id
                                                             """)
                                               .bind("id", tradeMarkId.id())
                                               .reduceRows(this::reduceTradeMarkRow))
                   .findFirst()
                   .orElseThrow();
    }

    public List<HammerTradeMarkEntity> retrieveAll() {
        return jdbi.withHandle(handle -> handle.createQuery("""
                                                       Select
                                                             tradeMark.trade_mark_name as tradeMarkName,
                                                             hammer.id as id,
                                                             hammer.name as name,
                                                             hammer.weight as weight,
                                                             hammer.size as size
                                                       from trade_mark_hammer tradeMark
                                                       inner join hammer hammer on hammer.trade_mark_id = tradeMark.id
                                                             """)
                                               .reduceRows(this::reduceTradeMarkRow))
                   .toList();
    }

    private void reduceTradeMarkRow(Map<String, HammerTradeMarkEntity> map, RowView rowView) {
        HammerTradeMarkEntity hammerTradeMarkEntity = map.computeIfAbsent(rowView.getColumn("tradeMarkName", String.class), __ -> rowView.getRow(HammerTradeMarkEntity.class));
        hammerTradeMarkEntity.hammers()
                             .add(rowView.getRow(HammerEntity.class));
    }
}
