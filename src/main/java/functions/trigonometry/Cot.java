package functions.trigonometry;

import lombok.AllArgsConstructor;

import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.NEGATIVE_INFINITY;

@AllArgsConstructor
public class Cot extends TrigonometryFunction {
    private Cos cos;
    private Sin sin;


    @Override
    public double compute(double x, double eps) {
        if ( ! validX(x) ) {
            throw new ArithmeticException("Wrong x");
        }

        double cosX = cos.compute(x, eps);
        double sinX = sin.compute(x, eps);

        return ( sinX == 0 ) ? ( cosX > 0 ? POSITIVE_INFINITY : NEGATIVE_INFINITY ) : cosX / sinX;
    }
}
