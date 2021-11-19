package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShopStore implements Store {

    private List<Food> products = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        if (getExpirationPercent(food) >= 0.25 && getExpirationPercent(food) <= 0.75) {
            return true;
        }
        if (getExpirationPercent(food) > 0 && getExpirationPercent(food) < 0.25) {
            food.setDiscount(0.5);
            food.setPrice(food.getPrice() * food.getDiscount());
            return true;
        }
            return false;
    }

    @Override
    public boolean save(Food food) {
        if (accept(food)) {
            products.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> findBy(Predicate<Food> filter) {
        return products.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
