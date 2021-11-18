package ru.job4j.lsp;

public class CarStore extends ParkingStore {
    public CarStore() {
        super(new CarStrategy());
    }
}
