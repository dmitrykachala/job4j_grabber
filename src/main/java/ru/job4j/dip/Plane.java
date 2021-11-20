package ru.job4j.dip;

public class Plane {

    private double fuel;

    public double fly(double fuel) {
        return Car.move(fuel);
    }
}
