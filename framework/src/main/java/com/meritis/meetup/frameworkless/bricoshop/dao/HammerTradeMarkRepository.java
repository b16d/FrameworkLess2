package com.meritis.meetup.frameworkless.bricoshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HammerTradeMarkRepository extends JpaRepository<HammerTradeMarkEntity, UUID> {
}
