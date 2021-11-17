package ru.job4j.lsp;

public interface StoreStrategy {

    default boolean apply(Food food) {
        return true;
    }

}

