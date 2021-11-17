package ru.job4j.lsp;

import java.util.Date;

public class ShopStrategy implements StoreStrategy {

    @Override
    public boolean apply(Food food) {
        if ((double) (food.getExpiryDate().getTime() - new Date().getTime())
                / (food.getExpiryDate().getTime() - food.getCreateDate().getTime()) <= 0.75
                && (double) (food.getExpiryDate().getTime() - new Date().getTime())
                / (food.getExpiryDate().getTime() - food.getCreateDate().getTime()) >= 0.25) {
            return true;
        } else if ((double) (food.getExpiryDate().getTime() - new Date().getTime())
                / (food.getExpiryDate().getTime() - food.getCreateDate().getTime()) < 0.25
                && (double) (food.getExpiryDate().getTime() - new Date().getTime())
                / (food.getExpiryDate().getTime() - food.getCreateDate().getTime()) > 0) {
            food.setDiscount(0.5);
            food.setPrice(food.getPrice() * food.getDiscount());
            return true;
        } else {
            return false;
        }
    }
}
