package ru.job4j.lsp;

import java.util.Date;

public class TrashStrategy implements StoreStrategy {

    @Override
    public boolean apply(Food food) {
        return food.getExpiryDate().getTime() < new Date().getTime();
    }
}
