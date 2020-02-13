package pl.marek;

public class NumbersH {

    private int max;
    private int[] prime;

    public NumbersH(int number) {
        this.max = number + 1;
        this.prime = new int[max];
    }

    int calculateNumbers() {
        int v = 5;
        int w = 5;
        int m = 0;
        int counter = 0;

        while (v < max) {
            while (w < max) {
                m = v * w;

                if (m >= max) {
                    break;
                }

                if (prime[v] == 0 && prime[w] == 0) {
                    prime[m] = -1;
                } else {
                    prime[m] = -2;
                }

                w += 4;
            }

            w = 5;
            v += 4;
        }


        for (int i = 0; i < max; i++) {
            if (prime[i] == -1) {
                counter++;
            }
        }

        return counter;
    }
}
