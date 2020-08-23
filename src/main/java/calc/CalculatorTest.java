package main.java.calc;

public class CalculatorTest {

    public static void main(String[] args) {

        Calc calc = new Calc();

        int x = calc.a;

        int sum = calc.add(2,3);
        calc.add(1, 2, 3, 4, 5, 6, 4, 5, 6, 7);
        System.out.println(sum);

    }
}
