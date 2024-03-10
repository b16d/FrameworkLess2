package com.meritis.meetup.frameworkless.bricoshop.service;

import com.meritis.meetup.frameworkless.bricoshop.dao.HammerDao;
import com.meritis.meetup.frameworkless.bricoshop.dao.HammerEntity;
import com.meritis.meetup.frameworkless.bricoshop.service.model.HammerId;
import com.meritis.meetup.frameworkless.hammer.record.Hammer;

public class HammerService {
    private final HammerDao hammerDao;

    public HammerService(HammerDao hammerDao) {
        this.hammerDao = hammerDao;
    }

    public Hammer retrieveById(HammerId hammerId) {
        HammerEntity entity = hammerDao.retrieveHammerById(hammerId);
        return new Hammer(entity.size(), entity.weight(), entity.name());
    }
}
