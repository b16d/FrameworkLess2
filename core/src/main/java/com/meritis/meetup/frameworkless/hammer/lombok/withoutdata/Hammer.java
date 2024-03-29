package com.meritis.meetup.frameworkless.hammer.lombok.withoutdata;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Hammer {
    public int size;
    public int weight;
    public String name;
}
