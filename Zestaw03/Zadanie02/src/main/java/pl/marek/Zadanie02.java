package pl.marek;

import java.util.ArrayList;
import java.util.List;

public class Zadanie02 {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{
                    "21",
                    "85",
                    "789",
                    "0"
            };
        }

        List<Integer> numbers = new ArrayList<>();
        for (String arg : args) {
            int number = Integer.parseInt(arg.replaceAll(" ", ""));
            if (number != 0) {
                numbers.add(number);
            }
        }

        for (int i : numbers) {
            System.out.printf("%d %d%n", i, new NumbersH(i).calculateNumbers());
        }
    }
}
