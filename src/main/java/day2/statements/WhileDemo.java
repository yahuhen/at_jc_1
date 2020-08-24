package main.java;

public class WhileDemo {

    public static void main(String[] args) {
        foo2();
    }

    static void foo() {
        int e = 0;
        for (int i = 23; i <= 28; i++) {
            if (i % 13 == 0) {
                System.out.println("continue!");

                continue;
                //break;
                //return;
            }
            e = i;
            System.out.println("i is : " + i);
        }
        System.out.println("number is : " + e);
    }

    static void foo2() {

        int[][] array = {{1, 2, 5}, {1, 2, 7}, {1, 4, 2}, {1, 2}, {1, 38, 2}};

        for (int i = 0; i < array.length; i++) {
            int[] inter = array[i];
            for (int e = 0; e < inter.length; e++) {
                System.out.print(inter[e]);
            }
            System.out.println();
        }

        for (int[] inter : array) {
            for (int e : inter) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

}
