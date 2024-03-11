package functions.trigonometry;

import static java.lang.Math.PI;

public class Cos extends TrigonometryFunction {
    @Override
    public double compute(double x, double eps) {
        if ( ! validX(x) ) {
            throw new ArithmeticException("Wrong x");
        }

        x %= 2 * PI;

        if ( x == -PI / 2 || x == ( -3 * PI ) / 2 ) {
            return 0d;
        }

        double res = 1d;
        int k = 2;
        double pow = Math.pow(x, 2);
        int sign = -1;
        long fact = 2;

        while ( true ) {
            double curTerm = ( ( sign * pow )  / fact );
            if ( Math.abs(curTerm) < eps ) {
                break;
            }

            res += curTerm;
            sign = -sign;
            fact *= (long) (k + 1) * ( k + 2 );
            pow *= Math.pow(x, 2);
            k += 2;
        }

        return res;
    }
}
