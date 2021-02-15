package ru.geekbrains.homework11;

import java.util.ArrayList;

public class Box<T extends Fruit> implements Comparable<Box> {

    ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public void putFruit(T fruit) {
        box.add(fruit);
    }

    public int getWeight() {
        float boxWeight = 0.0f;
        if (box.size() > 0) boxWeight = box.get(0).getFruitWeight() * box.size();
        return (int) boxWeight; //убираю дробную часть чтобы получить одинаковые по весу коробки
    }

    @Override
    public int compareTo(Box o) {
        if (getWeight() - o.getWeight() == 0) return 1;
        else return 0;
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public void empty(Box<T> other) {
        other.getBox().addAll(box);
        box.clear();
    }

}

