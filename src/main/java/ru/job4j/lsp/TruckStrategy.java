package ru.job4j.lsp;

public class TruckStrategy implements ParkingStrategy {

    @Override
    public boolean takePlace(Car car) {
        return car.getPlaces() > 1;
    }
}
