package pl.marek;

public class Cousine {

    private char[] a;
    private char[] b;

    public Cousine(char[] a, char[] b) {
        this.a = a;
        this.b = b;
    }

    public int relationship() {
        int[][] x = new int[128][128];
        int lengthA = a.length;
        int lengthB = b.length;

        for (int i = 0; i < lengthA; i++) {
            for (int j = 0; j < lengthB; j++) {
                if (a[i] == b[j]) {
                    x[i + 1][j + 1] = Math.max(x[i + 1][j + 1], x[i][j] + 1);
                } else {
                    x[i + 1][j + 1] = Math.max(x[i + 1][j], x[i][j + 1]);
                }
            }
        }

        int stepRelationship = 1;
        int length = x[lengthA][lengthB];

        if (lengthA > lengthB){
            int tempLength = lengthA;
            lengthA = lengthB;
            lengthB = tempLength;
        }

        while (length + length < lengthB) {
            length += lengthA;
            lengthA <<= 1;
            stepRelationship++;
        }

        return stepRelationship;
    }
}
