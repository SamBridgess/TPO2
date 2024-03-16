package functions.logarithms;

public class Ln extends LogarithmicFunction {

    @Override
    public double compute(double x, double eps) {
        if ( ! validX(x) ) {
            throw new ArithmeticException("Wrong x");
        }

        double constant = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1));

        double sum = 0;
        double curVal = (x - 1) / (x + 1);
        int step = 1;
        while (Math.abs(curVal) > eps / 2) {
            sum += curVal;
            curVal = (2 * step - 1) * curVal * constant / (2 * step + 1);
            step++;
        }
        sum *= 2;
        return sum;
    }
}
