package pl.marek;

public class Zadanie04 {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{
                    "4",
                    "3",
                    "100",
                    "20",
                    "100"
            };
        }


        int numberOfElements = Integer.parseInt(args[0]);
        long[] numbers = new long[numberOfElements];
        for (int i = 1; i <= numberOfElements; i++) {
            numbers[i - 1] = Long.parseLong(args[i]);
        }

        System.out.printf("%d%n", new Changes(numbers).h());
    }
}
