package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {

    }

    @Override
    public void passengersCount(int count) {

    }

    @Override
    public double getFuel(int liter) {
        double price =45.5;
        return liter * price;
    }
}
