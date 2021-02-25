package ru.geekbrains.homework14;

import java.util.ArrayList;

public class ArrayProcessing {

    public ArrayList<Integer> cutArray(ArrayList<Integer> array) {
        ArrayList<Integer> arrayNew = new ArrayList<>();
        boolean flag = true;
        if (array.get(array.size() - 1) != 4) {
            for (int i = array.size() - 2; i >= 0; i--) {
                if (array.get(i) == 4) {
                    flag = false;
                    for (int j = 0; j < (array.size() - i - 1); j++) {
                        arrayNew.add(j, array.get(i + j + 1));
                    }
                    break;
                }
            }
        } else if (array.get(array.size() - 1) == 4)
            flag = false;
        if (flag) throw new RuntimeException("Массив не содержит четверок");
        return arrayNew;
    }

    public boolean checkArray(ArrayList<Integer> array) {
        boolean flagOne = false;
        boolean flagFour = false;
        for (Integer integer : array) {
            if (integer != 1 && integer != 4) return false;
            if (integer == 1) flagOne = true;
            if (integer == 4) flagFour = true;
        }
        return flagOne && flagFour;
    }
}
