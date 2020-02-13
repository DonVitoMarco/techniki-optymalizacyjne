package pl.marek;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Changes {

    private long[] numbers;

    public Changes(long[] numbers) {
        this.numbers = numbers;
    }

    public long h() {
        int length = numbers.length;

        List<Pair<Integer, Long>> sortNumbers = new ArrayList<>();
        List<Pair<Integer, Boolean>> checks = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            sortNumbers.add(new Pair<>(i, numbers[i]));
            checks.add(new Pair<>(i, Boolean.FALSE));
        }
        sortNumbers.sort((Comparator.comparing(Pair::getRight)));


        long result = 0;
        for (int i = 0; i < length; i++) {
            if (checks.get(i).getRight() || sortNumbers.get(i).getRight() == i) {
                continue;
            }

            int cycle = 0;
            int j = i;

            while (!checks.get(j).getRight()) {
                checks.get(j).setRight(Boolean.TRUE);
                j = sortNumbers.get(j).getLeft();
                cycle++;
            }

            if (cycle > 0) {
                result += (cycle - 1);
            }
        }

        return result;
    }
}
