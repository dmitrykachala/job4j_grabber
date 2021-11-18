package ru.job4j.lsp.parking;

public class Car {

    private int places;

    public Car(int places) {
        this.places = places;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Car{" + "places=" + places + '}';
    }
}
