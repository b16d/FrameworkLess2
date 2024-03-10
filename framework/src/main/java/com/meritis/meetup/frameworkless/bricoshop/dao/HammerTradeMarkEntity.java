package com.meritis.meetup.frameworkless.bricoshop.dao;

import com.meritis.meetup.frameworkless.hammer.lombok.data.Hammer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "trade_mark_hammer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HammerTradeMarkEntity {
    @Id
    private UUID id;

    @Column(name = "trade_mark_name")
    private String name;

    @OneToMany(mappedBy = "hammerTradeMark")
    private List<HammerEntity> hammers;
}
