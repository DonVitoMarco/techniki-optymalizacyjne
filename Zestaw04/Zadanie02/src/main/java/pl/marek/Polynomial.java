package pl.marek;

public class Polynomial {

    private final double[] xValues;
    private final double[] yValues;
    private final double x;

    public Polynomial(double[] yValues) {
        this.yValues = yValues;
        this.xValues = new double[yValues.length];
        for (int i = 0; i < yValues.length; i++) {
            xValues[i] = i + 1;
        }
        this.x = xValues.length + 1;
    }

    public double findNext() {
        double temp;
        double resultY = 0;

        for (int i = 0; i < xValues.length; i++) {
            temp = 1;

            for (int j = 0; j < xValues.length; j++) {
                if (j != i) {
                    temp = temp * ((x - xValues[j]) / (xValues[i] - xValues[j]));
                }
            }

            resultY += temp * yValues[i];
        }

        return resultY;
    }
}
