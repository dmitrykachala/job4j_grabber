package ru.job4j.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingStoreTest {

    @Test
    public void addCarsAndTrue() {
        ParkingStore ps = new ParkingStore(2, 3);
        PassengerCar pCar = new PassengerCar();
        Truck truck = new Truck(2);
        boolean rslTruck = ps.takePlace(truck);
        boolean rslPCar = ps.takePlace(pCar);
        assertTrue(rslTruck);
        assertTrue(rslPCar);
    }

    @Test
    public void addCarsAndFalse() {
        ParkingStore ps = new ParkingStore(0, 0);
        PassengerCar pCar = new PassengerCar();
        Truck truck = new Truck(2);
        boolean rslTruck = ps.takePlace(truck);
        boolean rslPCar = ps.takePlace(pCar);
        assertFalse(rslTruck);
        assertFalse(rslPCar);
    }

    @Test
    public void whenTruckToCars() {
        ParkingStore ps = new ParkingStore(3, 0);
        Truck truck = new Truck(2);
        boolean rslTruck = ps.takePlace(truck);
        assertTrue(rslTruck);
    }
}