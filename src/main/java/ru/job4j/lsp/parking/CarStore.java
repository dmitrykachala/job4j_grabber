package ru.job4j.lsp.parking;

public class CarStore extends ParkingStore {
    public CarStore() {
        super(new CarStrategy());
    }
}
