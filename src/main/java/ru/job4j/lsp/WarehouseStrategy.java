package ru.job4j.lsp;

import java.util.Date;

public class WarehouseStrategy implements StoreStrategy {

    @Override
    public boolean apply(Food food) {
        return (double) (food.getExpiryDate().getTime() - new Date().getTime())
                / (food.getExpiryDate().getTime() - food.getCreateDate().getTime()) > 0.75;
    }
}
