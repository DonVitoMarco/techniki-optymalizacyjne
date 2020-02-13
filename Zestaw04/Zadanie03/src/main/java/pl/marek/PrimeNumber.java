package pl.marek;

public class PrimeNumber {

    private long number;

    public PrimeNumber(long number) {
        this.number = number;
    }

    public long firstPrimeNumberAfter() {
        long testNumber = number + 1;
        while (testNumber < Long.MAX_VALUE) {
            if (primeTest(testNumber) != 0)
                break;
            testNumber++;
        }
        return testNumber;
    }


    private long primeTest(long n) {
        long root;

        if (n % 2 == 0 || n % 3 == 0) {
            return 0;
        }

        root = (long) Math.sqrt(n);

        int i = 5;
        int j = 7;
        for (; i <= root; i += 6, j += 6) {
            if (n % i == 0) {
                return 0;
            }
            if (n % j == 0) {
                return 0;
            }
        }

        return 1;
    }

}
