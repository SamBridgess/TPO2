package functions;

public abstract class AbstractFunction {
    public boolean validX(double x) {
        return ( ! ( Double.isNaN(x) || Double.isInfinite(x) ) );
    }

    public abstract double compute(double x, double eps);
}
