package ru.job4j.lsp.food;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public interface Store {

    boolean save(Food food);

    boolean accept(Food food);

    default double getExpirationPercent(Food food) {
        return (double) (food.getExpiryDate().getTime() - new Date().getTime())
                / (food.getExpiryDate().getTime() - food.getCreateDate().getTime());
    }

    void clean();

    List<Food> findBy(Predicate<Food> filter);

}
