package com.meritis.meetup.frameworkless.hammer.lombok.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HammerTradeMark {
    public List<Hammer> hammers;
    public String name;
}
