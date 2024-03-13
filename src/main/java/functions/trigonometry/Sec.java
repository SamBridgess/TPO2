package functions.trigonometry;

import lombok.AllArgsConstructor;

import static java.lang.Double.POSITIVE_INFINITY;

@AllArgsConstructor
public class Sec extends TrigonometryFunction {
    private Cos cos;

    @Override
    public double compute(double x, double eps) {
        if ( ! validX(x) ) {
            throw new ArithmeticException("Wrong x");
        }

        double cosX = cos.compute(x, eps);

        return cosX == 0 ? POSITIVE_INFINITY : 1 / cosX;
    }
}
