package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingStore {

    private final List<Car> cars = new ArrayList<>();
    private final ParkingStrategy strategy;

    protected ParkingStore(ParkingStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean apply(Car car) {
        if (strategy != null && strategy.takePlace(car)) {
            cars.add(car);
            return true;
        }
        return false;
    }

    public ParkingStrategy getStrategy() {
        return strategy;
    }
}
