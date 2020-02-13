package pl.marek;

import java.math.BigInteger;

public class Fibbonacci {

    private int number;

    public Fibbonacci(int number) {
        this.number = number;
    }

    public BigInteger getResult() {
        int x = number;
        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;

        while (x > 2) {
            sum = f1.add(f2);
            f2 = f1;
            f1 = sum;
            x--;
        }

        return sum;
    }
}
