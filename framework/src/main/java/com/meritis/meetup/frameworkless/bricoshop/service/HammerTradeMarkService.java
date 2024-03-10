package com.meritis.meetup.frameworkless.bricoshop.service;

import com.meritis.meetup.frameworkless.bricoshop.dao.HammerTradeMarkEntity;
import com.meritis.meetup.frameworkless.bricoshop.dao.HammerTradeMarkRepository;
import com.meritis.meetup.frameworkless.hammer.lombok.data.Hammer;
import com.meritis.meetup.frameworkless.hammer.lombok.data.HammerTradeMark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HammerTradeMarkService {
    private final HammerTradeMarkRepository hammerTradeMarkRepository;

    @Autowired
    public HammerTradeMarkService(HammerTradeMarkRepository hammerTradeMarkRepository) {
        this.hammerTradeMarkRepository = hammerTradeMarkRepository;
    }

    public HammerTradeMark retrieveTradeMarkHammer(UUID id) {
        HammerTradeMarkEntity hammerTradeMarkEntity = hammerTradeMarkRepository.getReferenceById(id);
        List<Hammer> hammers = hammerTradeMarkEntity.getHammers()
                                                    .stream()
                                                    .map(ham -> new Hammer(ham.getSize(), ham.getWeight(), ham.getName()))
                                                    .toList();
        return new HammerTradeMark(hammers, hammerTradeMarkEntity.getName());
    }
}
