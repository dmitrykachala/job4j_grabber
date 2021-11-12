package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, (p1, p2) -> comparator.compare(p1, p2) >= 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare(value, (p1, p2) -> comparator.compare(p1, p2) < 0);
    }

    public <T> T compare(List<T> value, BiPredicate<T, T> predicate) {
        T rsl = null;
        if (value.size() > 0) {
            rsl = value.get(0);
            for (T t : value) {
                if (predicate.test(t, rsl)) {
                    rsl = t;
                }
            }
        }
        return rsl;
    }

}

