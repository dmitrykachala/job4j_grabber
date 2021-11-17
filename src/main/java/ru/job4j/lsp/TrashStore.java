package ru.job4j.lsp;

public class TrashStore extends Store {
    public TrashStore() {
        super(new TrashStrategy());
    }
}
