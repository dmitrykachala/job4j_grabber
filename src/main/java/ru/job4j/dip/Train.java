package ru.job4j.dip;

public class Train {

    private double fuel;
    private int carriageCount;
    private double carriageWeight;

    public int maxCarriageCount(double fuel, double carriageWeight) {
        Car.haul(fuel, carriageWeight);
        return 0;
    }
}
