package com.meritis.meetup.frameworkless.bricoshop.service;

import com.meritis.meetup.frameworkless.bricoshop.dao.HammerTradeMarkDao;
import com.meritis.meetup.frameworkless.bricoshop.dao.HammerTradeMarkEntity;
import com.meritis.meetup.frameworkless.bricoshop.service.model.HammerTradeMarkId;
import com.meritis.meetup.frameworkless.hammer.record.Hammer;
import com.meritis.meetup.frameworkless.hammer.record.HammerTradeMark;

import java.util.List;

public class HammerTradeMarkService {
    private final HammerTradeMarkDao hammerTradeMarkDao;

    public HammerTradeMarkService(HammerTradeMarkDao hammerTradeMarkDao) {
        this.hammerTradeMarkDao = hammerTradeMarkDao;
    }

    public HammerTradeMark retrieveTradeMarkHammer(HammerTradeMarkId hammerTradeMarkId) {
        HammerTradeMarkEntity entity = hammerTradeMarkDao.retrieve(hammerTradeMarkId);
        List<Hammer> hammers = entity.hammers()
                                     .stream()
                                     .map(ham -> new Hammer(ham.size(), ham.weight(), ham.name()))
                                     .toList();
        return new HammerTradeMark(hammers, entity.tradeMarkName());
    }
}
