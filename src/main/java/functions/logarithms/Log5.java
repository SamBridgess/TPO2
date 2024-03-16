package functions.logarithms;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Log5 extends LogarithmicFunction {
    private Ln ln;

    @Override
    public double compute(double x, double eps) {
        if ( ! validX(x) ) {
            throw new ArithmeticException("Wrong x");
        }

        return ln.compute(x, eps) / 1.60943791243;
    }
}
