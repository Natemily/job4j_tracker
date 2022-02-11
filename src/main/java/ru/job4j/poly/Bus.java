package ru.job4j.poly;

public class Bus implements Transport {

    private int flow;

    @Override
    public void drive() {
        if (flow > 0) {
            System.out.println("Можно ехать");
        }
    }

    @Override
    public void passenger(int quantity) {
        flow += quantity;
    }

    @Override
    public int refuel(int fuel) {
        int cost = fuel * 2;
        return cost;
    }
}
