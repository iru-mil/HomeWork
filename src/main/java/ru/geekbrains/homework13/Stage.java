package ru.geekbrains.homework13;

public abstract class Stage {
    protected int length;
    protected String description;

    public abstract void go(Car c);
}