package functions.logarithms;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Log10 extends LogarithmicFunction {
    private Ln ln;

    @Override
    public double compute(double x, double eps) {
        if ( ! validX(x) ) {
            throw new ArithmeticException("Wrong x");
        }

        return ln.compute(x, eps) / 2.30258509299;
    }
}
