package ru.geekbrains.homework11;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        String[] arrayEx1 = {"!!!", "всем", "Привет"};
        Integer[] arrayEx2 = {1, 2, 3, 4, 5};
        Float[] arrayEx3 = {1.1f, 2.2f, 3.3f, 4.4f};

        swapPlaces(arrayEx1, 0, 2);
        convertToList(arrayEx2);
        convertToList(arrayEx3);

        Box<Apple> boxApple1 = new Box<>();
        Box<Apple> boxApple2 = new Box<>();
        Box<Orange> boxOrange1 = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();

        int n = 1000;
        for (int i = 0; i < n; i++) {
            boxApple1.putFruit(new Apple());
            boxOrange1.putFruit(new Orange());
            if (i < n / 1.5) {
                boxApple2.putFruit(new Apple());
                boxOrange2.putFruit(new Orange());
            }
        }

        System.out.println("Коробка яблок 1 весит: " + boxApple1.getWeight());
        System.out.println("Коробка яблок 2 весит: " + boxApple2.getWeight());
        System.out.println("Коробка апельсинов 1 весит: " + boxOrange1.getWeight());
        System.out.println("Коробка апельсинов 2 весит: " + boxOrange2.getWeight());

        System.out.println(boxApple1.compareTo(boxOrange1));
        System.out.println(boxApple1.compareTo(boxOrange2));

        boxApple2.empty(boxApple1);
        boxOrange2.empty(boxOrange1);

        System.out.println("Коробка яблок 1 весит: " + boxApple1.getWeight());
        System.out.println("Коробка яблок 2 весит: " + boxApple2.getWeight());
        System.out.println("Коробка апельсинов 1 весит: " + boxOrange1.getWeight());
        System.out.println("Коробка апельсинов 2 весит: " + boxOrange2.getWeight());
    }

    public static <T> void swapPlaces(T[] array, int i1, int i2) {
        T buffer = array[i1];
        array[i1] = array[i2];
        array[i2] = buffer;
        for (T t : array) {
            System.out.print(" " + t);
        }
        System.out.println();
    }

    public static <T> void convertToList(T[] array) {
        ArrayList<T> list = new ArrayList<>();
        for (T t : array) {
            list.add(t);
        }
        System.out.println("Преобразованный массив: " + list);
    }
}
