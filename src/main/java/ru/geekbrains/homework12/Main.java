package ru.geekbrains.homework12;

import java.util.Arrays;

public class Main {
    static final int size = 10_000_000;
    static final int half = size / 2;

    public static class ThreadArray1 extends Thread {
        public float[] array;

        public ThreadArray1(float[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            for (int i = 0; i < size; i++) {
                this.array[i] = (float) (this.array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4 + i / 2));
            }
        }
    }

    public static class ThreadArray2Part1 extends Thread {
        public float[] array;

        public ThreadArray2Part1(float[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            for (int i = 0; i < half; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4 + i / 2));
            }
        }
    }

    public static class ThreadArray2Part2 extends Thread {
        public float[] array;

        public ThreadArray2Part2(float[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            for (int i = 0; i < half; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + (i + half) / 5) * Math.cos(0.2f + (i + half) / 5) * Math.cos(0.4 + (i + half) / 2));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.equals(createArray1(), createArray2()));

    }

    public static float[] createArray1() throws InterruptedException {
        float[] array1 = new float[size];
        Arrays.fill(array1, 1.0f);
        long a1 = System.currentTimeMillis();
        ThreadArray1 t = new ThreadArray1(array1);
        t.start();
        t.join();
        System.out.println("Массив 1 создан за " + (System.currentTimeMillis() - a1));
        return array1;
    }

    public static float[] createArray2() throws InterruptedException {
        float[] array2 = new float[size];
        Arrays.fill(array2, 1.0f);
        long a2 = System.currentTimeMillis();
        float[] array2Copy1 = new float[half];
        float[] array2Copy2 = new float[half];

        System.arraycopy(array2, 0, array2Copy1, 0, half);
        System.arraycopy(array2, half, array2Copy2, 0, half);
        ThreadArray2Part1 t1 = new ThreadArray2Part1(array2Copy1);
        ThreadArray2Part2 t2 = new ThreadArray2Part2(array2Copy2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.arraycopy(array2Copy1, 0, array2, 0, half);
        System.arraycopy(array2Copy2, 0, array2, half, half);

        System.out.println("Массив 2 создан за " + (System.currentTimeMillis() - a2));
        return array2;
    }
}
