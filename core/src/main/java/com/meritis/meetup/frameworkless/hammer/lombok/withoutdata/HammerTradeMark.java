package com.meritis.meetup.frameworkless.hammer.lombok.withoutdata;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class HammerTradeMark {
    public List<Hammer> hammers;
}
