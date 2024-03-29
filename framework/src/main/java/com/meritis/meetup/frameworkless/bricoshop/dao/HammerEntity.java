package com.meritis.meetup.frameworkless.bricoshop.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Hammer")
public class HammerEntity {
    @Id
    private UUID id;

    @Column
    private String Name;

    @Column
    private int size;

    @Column
    private int weight;

    @ManyToOne
    @JoinColumn(name = "trade_mark_id")
    private HammerTradeMarkEntity hammerTradeMark;
}