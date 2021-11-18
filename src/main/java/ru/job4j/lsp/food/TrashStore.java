package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TrashStore implements Store {

    private List<Food> products = new ArrayList<>();

    @Override
    public void save(Food food) {
        products.add(food);
    }

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return products.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
