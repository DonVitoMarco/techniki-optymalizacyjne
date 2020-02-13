package pl.marek;

import java.util.Arrays;

public class Antimonotoncity {

    private int[] sequence;
    private int sequenceLength;

    public Antimonotoncity(int[] set) {
        this.sequenceLength = set[0];
        this.sequence = Arrays.copyOfRange(set, 1, set.length);
    }

    public int longestAntimonotoncitySubsequence() {
        int n = 0;
        int count = 0;
        int current = 0;
        int next = 0;

        while (n < sequenceLength - 1) {
            current = sequence[n];
            next = sequence[n + 1];

            if (count % 2 == 0) {
                if (current > next) {
                    count++;
                }
            } else if (current < next) {
                count++;
            }

            n++;
        }

        if (count % 2 == 0) {
            if (current < next) {
                count++;
            }
        } else if (current > next) {
            count++;
        }

        return count;
    }
}
