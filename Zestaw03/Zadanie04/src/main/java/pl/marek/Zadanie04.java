package pl.marek;

import java.util.ArrayList;
import java.util.List;

public class Zadanie04 {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{
                    "10 11",
                    "100 200",
                    "0 500",
                    "1234567890 2345678901",
                    "0 4294967295",
                    "-1 -1"
            };
        }

        List<long[]> sets = parse(args);

        for (long[] set : sets) {
            System.out.printf("%s%n", new Zeros(set[0], set[1]).numberOfZeros());
        }
    }

    public static List<long[]> parse(String[] args) {
        List<long[]> sets = new ArrayList<>();

        for (int i = 0; i <= args.length - 1; i++) {
            String[] numbers = args[i].split(" ");
            long[] parsedNumbers = new long[2];
            parsedNumbers[0] = Long.parseLong(numbers[0]);
            parsedNumbers[1] = Long.parseLong(numbers[1]);

            if (parsedNumbers[0] != -1 && parsedNumbers[1] != -1) {
                sets.add(parsedNumbers);
            }
        }

        return sets;
    }
}
