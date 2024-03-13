package functions.trigonometry;

import lombok.AllArgsConstructor;

import static java.lang.Double.POSITIVE_INFINITY;

@AllArgsConstructor
public class Csc extends TrigonometryFunction {
    private Sin sin;

    @Override
    public double compute(double x, double eps) {
        if ( ! validX(x) ) {
            throw new ArithmeticException("Wrong x");
        }

        double sinX = sin.compute(x, eps);

        return sinX == 0 ? POSITIVE_INFINITY : 1 / sinX;
    }
}
