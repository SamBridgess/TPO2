package functions.trigonometry;

import static java.lang.Math.PI;

public class Sin extends TrigonometryFunction {
    private final Cos cos;

    public Sin(Cos cos) {
        this.cos = cos;
    }

    @Override
    public double compute(double x, double eps) {
        if ( ! validX(x) ) {
            throw new ArithmeticException("Wrong x");
        }

        x %= 2 * PI;

        if ( x == 0 || x == -PI ) {
            return 0d;
        }

        double cosX = cos.compute(x, eps);
        double res = Math.sqrt(1 - Math.pow(cosX, 2));

        return ( ( x < 0 ) && ( x > -PI ) ) ? -res : res;
    }
}
