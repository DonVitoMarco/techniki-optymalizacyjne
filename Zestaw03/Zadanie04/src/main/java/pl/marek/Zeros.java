package pl.marek;

import java.util.Arrays;

public class Zeros {

    private long m;
    private long n;

    public Zeros(long m, long n) {
        this.m = m;
        this.n = n;
    }

    public long numberOfZeros() {
        return numberOfZerosFromZero(Math.max(m, n)) - numberOfZerosFromZero(Math.min(m, n) - 1);
    }

    private long numberOfZerosFromZero(long number) {
        if (number < 0) {
            return 0;
        }
        int memLength = 20;
        long result = 1;

        char[] charNumber = String.valueOf(number).toCharArray();
        int n = charNumber.length;

        long[] powers = new long[memLength];
        Arrays.fill(powers, 1);
        for (int i = 1; i < memLength; i++) {
            powers[i] = powers[i - 1] * 10;
        }

        long[] suffix = new long[memLength];
        suffix[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + (charNumber[i] - '0') * powers[n - i - 1];
        }

        int prefix = 0;
        for (int i = 1; i < n; i++) {
            prefix = prefix * 10 + (charNumber[i - 1] - '0');

            if (charNumber[i] != '0') {
                result += prefix * powers[n - i - 1];
            } else {
                result += (prefix - 1) * powers[n - i - 1] + suffix[i + 1] + 1;
            }
        }

        return result;
    }
}
