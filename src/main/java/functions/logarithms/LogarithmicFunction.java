package functions.logarithms;

import functions.AbstractFunction;

public abstract class LogarithmicFunction extends AbstractFunction {

    @Override
    public boolean validX(double x) {
        if ( ! super.validX(x) ) {
            return false;
        }

        return x > 0;
    }
}
