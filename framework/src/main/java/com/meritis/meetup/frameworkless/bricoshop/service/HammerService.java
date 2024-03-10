package com.meritis.meetup.frameworkless.bricoshop.service;

import com.meritis.meetup.frameworkless.bricoshop.dao.HammerEntity;
import com.meritis.meetup.frameworkless.bricoshop.dao.HammerRepository;
import com.meritis.meetup.frameworkless.hammer.lombok.data.Hammer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HammerService {
    private final HammerRepository hammerRepository;

    @Autowired
    public HammerService(HammerRepository hammerRepository) {
        this.hammerRepository = hammerRepository;
    }

    public Hammer retrieveById(UUID hammerId) {
        HammerEntity entity = hammerRepository.getReferenceById(hammerId);
        Hammer hammer = new Hammer();
        hammer.setSize(entity.getSize());
        hammer.setWeight(entity.getWeight());
        hammer.setName(entity.getName());
        return hammer;
    }

}
