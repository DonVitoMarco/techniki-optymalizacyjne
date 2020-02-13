package pl.marek;

import java.util.ArrayList;
import java.util.List;

public class Zadanie01 {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{
                    "4",
                    "5 1 2 3 4 5",
                    "5 5 4 3 2 1",
                    "5 5 1 4 2 3",
                    "5 2 4 1 3 5"
            };
        }

        List<int[]> sets = parse(args);
        for (int[] set : sets) {
            System.out.printf("%d%n", new Antimonotoncity(set).longestAntimonotoncitySubsequence());
        }
    }


    public static List<int[]> parse(String[] args) {
        List<int[]> sets = new ArrayList<>();

        int numberOfSets = Integer.parseInt(args[0]);

        for (int i = 1; i <= numberOfSets; i++) {
            String[] numbers = args[i].split(" ");

            int[] set = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                set[j] = Integer.parseInt(numbers[j]);
            }

            sets.add(set);
        }

        return sets;
    }
}
