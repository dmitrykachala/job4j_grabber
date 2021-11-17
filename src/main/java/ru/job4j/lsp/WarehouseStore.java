package ru.job4j.lsp;

public class WarehouseStore extends Store {
    public WarehouseStore() {
        super(new WarehouseStrategy());
    }
}
