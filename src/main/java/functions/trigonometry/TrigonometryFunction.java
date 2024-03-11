package functions.trigonometry;
import functions.AbstractFunction;

public abstract class TrigonometryFunction extends AbstractFunction {
    @Override
    public boolean validX(double x) {
        if ( ! super.validX(x) ) {
            return false;
        }

        return x <= 0;
    }
}
