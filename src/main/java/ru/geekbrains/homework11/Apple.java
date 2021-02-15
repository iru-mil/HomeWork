package ru.geekbrains.homework11;

public class Apple extends Fruit {
    static float weight = 1.0f;

    public Apple() {
    }

    @Override
    public float getFruitWeight() {
        return weight;
    }
}
