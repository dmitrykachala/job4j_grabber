package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class Store {

    private final List<Food> products = new ArrayList<>();
    private final StoreStrategy s;

    protected Store(StoreStrategy s) {
        this.s = s;
    }

    public boolean apply(Food food) {
        if (s != null && s.apply(food)) {
            products.add(food);
            return true;
        }
        return false;
    }

    public List<Food> findBy(Predicate<Food> filter) {
        return products.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    public StoreStrategy getStrategy() {
        return s;
    }
}
