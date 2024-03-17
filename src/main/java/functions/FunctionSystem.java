package functions;

import functions.logarithms.LogarithmicExpression;
import functions.trigonometry.TrigonometricExpression;

public class FunctionSystem {
    private final LogarithmicExpression logCalculator;
    private final TrigonometricExpression trigCalculator;

    public FunctionSystem(LogarithmicExpression logCalculator, TrigonometricExpression trigCalculator) {
        this.logCalculator = logCalculator;
        this.trigCalculator = trigCalculator;
    }

    public Double calculate(Double x, Double eps) {
        return x > 0 ? logCalculator.calculate(x, eps) : trigCalculator.calculate(x, eps);
    }

}