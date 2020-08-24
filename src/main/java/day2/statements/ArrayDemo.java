package main.java;

import java.util.Random;

public class ArrayDemo {

    public static void main(String[] args) {

        Random random = new Random();
        int[] array = new int[random.nextInt(100)];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        int avg = 0;

        for (int i : array) {
            System.out.println("value is: " + i);
            avg += i;
        }

        System.out.println("Average value is: " + avg / array.length);
    }

}
