package ru.job4j.lsp;

public class ShopStore extends Store {
    public ShopStore() {
        super(new ShopStrategy());
    }
}
