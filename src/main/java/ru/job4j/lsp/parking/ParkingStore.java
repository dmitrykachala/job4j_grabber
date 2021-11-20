package ru.job4j.lsp.parking;

public class ParkingStore implements Parking {

    private int carsCount;
    private int trucksCount;

    private final Car[] pCars = new Car[carsCount];
    private final Truck[] trucks = new Truck[trucksCount];

    protected ParkingStore(int carsCount, int trucksCount) {
        this.carsCount = carsCount;
        this.trucksCount = trucksCount;
    }

    public boolean takePlace(Car car) {
        return false;
    }

}
