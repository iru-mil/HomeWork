package ru.geekbrains.homework10;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    public static HashMap<String, String> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        phoneBook.put("+7 926 075-88-74", "Ivanov");
        phoneBook.put("+7 928 680-85-05", "Petrov");
        phoneBook.put("+7 925 852-12-12", "Orlov");
        phoneBook.put("+7 929 055-78-08", "Voronov");
        phoneBook.put("+7 968 101-01-01", "Ivanov");
        phoneBook.put("+7 903 200-00-20", "Sidorov");
        phoneBook.put("+7 918 857-57-85", "Orlov");
        phoneBook.put("+7 912 365-33-89", "Ivanov");
        phoneBook.put("+7 938 241-43-48", "Putin");
        phoneBook.put("+7 928 903-33-60", "Mileev");


        add("Krilov", "+7 962 351-87-78");
        add("Putin", "+7 928 685-04-44");

        for (Map.Entry<String, String> o : phoneBook.entrySet()) {
            System.out.println(o.getValue() + " : " + o.getKey());
        }
        get("Ivanov");
    }

    public static void add(String name, String number) {
        phoneBook.put(number, name);
    }

    public static void get(String name) {
        System.out.println(name + "'s phone number(s): ");
        for (Map.Entry<String, String> o : phoneBook.entrySet()) {
            if (name.equals(o.getValue()))
                System.out.println(o.getKey());
        }
    }
}
