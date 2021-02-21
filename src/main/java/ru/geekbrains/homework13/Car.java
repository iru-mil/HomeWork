package ru.geekbrains.homework13;

import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;
    private final Object lock = new Object();
    private static final AtomicBoolean flag = new AtomicBoolean(true);


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            Main.cb.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        try {
            Main.cb1.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            if (flag.compareAndExchange(true, false)) {
                System.out.println(this.name + " - WIN");
            }
        }
    }
}
