package ru.job4j.lsp;

public class TruckStore extends ParkingStore {
    public TruckStore() {
        super(new TruckStrategy());
    }
}
