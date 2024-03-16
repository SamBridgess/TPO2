package functions;

import functions.logarithms.LogarithmicExpression;
import functions.trigonometry.TrigonometricExpression;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppExpressionImpl implements AppExpression {
    private final TrigonometricExpression trigonometricExpression;
    private final LogarithmicExpression logarithmicExpression;


    @Override
    public double compute(double x, double eps) {
        Expression computingElement = x > 0 ? logarithmicExpression : trigonometricExpression;
        return computingElement.calculate(x, eps);
    }
}
