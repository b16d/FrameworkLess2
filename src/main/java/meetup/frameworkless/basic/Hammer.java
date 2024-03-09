package meetup.frameworkless.basic;

import java.util.Objects;

public class Hammer {
    public int size;

    public int weight;
    public Hammer(int size, int weight) {
        this.size = size;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hammer hammer)) return false;
        return size == hammer.size && weight == hammer.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, weight);
    }

    @Override
    public String toString() {
        return "Hammer{" +
                "size=" + size +
                ", weight=" + weight +
                '}';
    }
}

