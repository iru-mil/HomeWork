package ru.geekbrains.homework10;

import java.util.*;

public class Words {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        arrayList.add("black");
        arrayList.add("white");
        arrayList.add("green");
        arrayList.add("white");
        arrayList.add("red");
        arrayList.add("blue");
        arrayList.add("black");
        arrayList.add("brown");
        arrayList.add("red");
        arrayList.add("yellow");
        arrayList.add("black");
        arrayList.add("pink");
        arrayList.add("red");
        arrayList.add("orange");
        arrayList.add("brown");
        arrayList.add("yellow");
        arrayList.add("violet");
        arrayList.add("blue");

        Set<String> set = new HashSet<>(arrayList);

        System.out.println(arrayList);
        System.out.println(set);

        for (String str : set) {
            map.put(str, 0);
        }
        for (Map.Entry<String, Integer> o : map.entrySet()) {
            int j = 0;
            String strMap = o.getKey();
            for (String strArray : arrayList) {
                if (strMap.equals(strArray)) {
                    map.put(strMap, j + 1);
                    j++;
                }
            }
        }
        for (Map.Entry<String, Integer> o : map.entrySet()) {
            System.out.println(o.getKey() + " : " + o.getValue());
        }
    }
}
