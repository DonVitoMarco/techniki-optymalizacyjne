package pl.marek;

import java.util.ArrayList;
import java.util.List;

public class Zadanie03 {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{
                    "a",
                    "b",
                    "abb",
                    "baa",
                    "abcdef",
                    "axcyd",
                    "0",
                    "0"
            };
        }

        List<char[]> texts = new ArrayList<>();
        for (String arg : args) {
            if (!arg.equals("0")) {
                texts.add(arg.toCharArray());
            }
        }

        for (int i = 0; i < texts.size(); i += 2) {
            System.out.printf("%d%n", new Cousine(texts.get(i), texts.get(i + 1)).relationship());
        }
    }
}
