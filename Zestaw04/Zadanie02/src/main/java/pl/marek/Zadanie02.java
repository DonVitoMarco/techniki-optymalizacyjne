package pl.marek;

import java.util.ArrayList;
import java.util.List;

public class Zadanie02 {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{
                    "2 3 4 5",
                    "9 45 141 327"
            };
        }

        List<double[]> sets = new ArrayList<>();
        for (String arg : args) {
            String[] numbers = arg.split(" ");
            double[] set = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                set[i] = Double.parseDouble(numbers[i]);
            }
            sets.add(set);
        }

        for (double[] set : sets) {
            Polynomial polynomial = new Polynomial(set);
            System.out.printf("%.0f%n", polynomial.findNext());
        }
    }
}
