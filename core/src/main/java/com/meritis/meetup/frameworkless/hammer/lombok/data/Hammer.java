package com.meritis.meetup.frameworkless.hammer.lombok.data;

import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hammer {
    public int size;
    public int weight;
    public String name;

}

