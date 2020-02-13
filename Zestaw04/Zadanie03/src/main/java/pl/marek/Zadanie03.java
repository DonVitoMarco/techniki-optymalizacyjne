package pl.marek;

import java.util.ArrayList;
import java.util.List;

public class Zadanie03 {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{
                    "3",
                    "6",
                    "20",
                    "100"
            };
        }

        List<Long> numbers = new ArrayList<>();
        int numberOfSets = Integer.parseInt(args[0]);
        for (int i = 1; i <= numberOfSets; i++) {
            numbers.add(Long.parseLong(args[i]));
        }

        for (long number : numbers) {
            System.out.printf("%d%n", new PrimeNumber(number).firstPrimeNumberAfter());
        }
    }
}
