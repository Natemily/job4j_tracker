package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
    }

    @Override
    public void passenger(int quantity) {
    }

    @Override
    public int refuel(int fuel) {
        int cost = fuel * 2;
        return cost;
    }
}
