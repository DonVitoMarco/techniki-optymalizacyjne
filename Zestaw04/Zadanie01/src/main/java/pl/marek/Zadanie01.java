package pl.marek;

import java.util.ArrayList;
import java.util.List;

public class Zadanie01 {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{
                    "6",
                    "100"
            };
        }

        List<Integer> numbers = new ArrayList<>();
        for (String arg : args) {
            numbers.add(Integer.parseInt(arg.replaceAll(" ", "")));
        }

        for (int number : numbers) {
            System.out.printf("%s%n", new Fibbonacci(number).getResult().toString());
        }
    }
}
