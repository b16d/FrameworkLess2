package com.meritis.meetup.frameworkless.hammer.basic;

import java.util.Objects;

public class Hammer {
    public int size;
    public int weight;

    public String name;

    public Hammer(int size, int weight, String name) {
        this.size = size;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Hammer hammer = (Hammer) o;
        return size == hammer.size && weight == hammer.weight && Objects.equals(name, hammer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, weight, name);
    }

    @Override
    public String toString() {
        return "Hammer{" + "size=" + size + ", weight=" + weight + ", name='" + name + '\'' + '}';
    }
}

