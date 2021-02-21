package ru.geekbrains.homework13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int CARS_COUNT = 4;
    public static final Semaphore smp = new Semaphore(CARS_COUNT / 2);
    public static final CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1);
    public static final CyclicBarrier cb1 = new CyclicBarrier(CARS_COUNT);


    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            new Thread(car).start();
        }

        if (!cb1.isBroken()) {
            try {
                Thread.sleep(1500);
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                cb.await();
                Thread.sleep(12000);

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

    }
}






