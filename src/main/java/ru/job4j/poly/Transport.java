package ru.job4j.poly;

public interface Transport {
    void drive();

    void passenger(int quantity);

    int refuel(int fuel);
}
