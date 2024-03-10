package com.meritis.meetup.frameworkless.hammer.basic;

import java.util.List;
import java.util.Objects;

public class HammerTradeMark {
    public List<Hammer> hammers;

    public HammerTradeMark(List<Hammer> hammers) {
        this.hammers = hammers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        HammerTradeMark that = (HammerTradeMark) o;
        return Objects.equals(hammers, that.hammers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hammers);
    }

    @Override
    public String toString() {
        return "HammerTradeMark{" + "hammers=" + hammers + '}';
    }
}
