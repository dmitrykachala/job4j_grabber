package ru.job4j.lsp.parking;

public class TruckStore extends ParkingStore {
    public TruckStore() {
        super(new TruckStrategy());
    }
}
