package ru.job4j.lsp.food;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    void save(Food food);

    List<Food> findBy(Predicate<Food> filter);

}
