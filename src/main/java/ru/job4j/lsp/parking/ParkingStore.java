package ru.job4j.lsp.parking;

public class ParkingStore implements Parking {

    private int carsCount;
    private int trucksCount;

    private Car[] pCars;
    private Car[] trucks;
    private int tCounter = 0;
    private int cCounter = 0;

    public ParkingStore(int carsCount, int trucksCount) {
        this.carsCount = carsCount;
        this.trucksCount = trucksCount;
        pCars = new Car[carsCount];
        trucks  = new Truck[trucksCount];
    }

    public boolean takePlace(Car car) {

        int tFree = trucksCount - tCounter;
        int cFree = carsCount - cCounter;
        int tIn = tCounter;
        int cIn = cCounter;

        if (car.getPlaces() > 1) {
            if (tFree >= 1) {
                trucks[tCounter] = car;
                tCounter++;
            } else if (cFree >= car.getPlaces()) {
                for (int i = 0; i < car.getPlaces(); i++) {
                    pCars[cCounter] = car;
                    cCounter++;
                }
            }
        }
        if (cFree >= 1) {
            pCars[cCounter] = car;
            cCounter++;
        }
        return (tIn != tCounter || cIn != cCounter);
    }

}
