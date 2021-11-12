package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T max = null;
        if (value.size() > 0) {
            max = value.get(0);
            for (T t : value) {
                if (comparator.compare(max, t) < 0) {
                    max = t;
                }
            }
        }
        return max;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }

}

