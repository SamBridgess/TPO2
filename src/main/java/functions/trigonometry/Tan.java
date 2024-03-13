package functions.trigonometry;

import lombok.AllArgsConstructor;

import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.NEGATIVE_INFINITY;

@AllArgsConstructor
public class Tan extends TrigonometryFunction {
    private Cos cos;
    private Sin sin;

    @Override
    public double compute(double x, double eps) {
        if ( ! validX(x) ) {
            throw new ArithmeticException("Wrong x");
        }

        double sinX = sin.compute(x, eps);
        double cosX = cos.compute(x, eps);

        return ( cosX == 0 ) ? ( sinX > 0 ? POSITIVE_INFINITY : NEGATIVE_INFINITY ) : sinX / cosX;
    }
}
