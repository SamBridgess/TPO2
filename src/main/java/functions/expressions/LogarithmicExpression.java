package functions.expressions;

import functions.logarithms.Ln;
import functions.logarithms.Log10;
import functions.logarithms.Log3;
import functions.logarithms.Log5;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LogarithmicExpression implements Expression {
    private final Ln ln;
    private final Log3 log3;
    private final Log5 log5;
    private final Log10 log10;

    @Override
    public double calculate(double x, double eps) {
        double ln = this.ln.compute(x, eps);
        double log3 = this.log3.compute(x, eps);
        double log5 = this.log5.compute(x, eps);
        double log10 = this.log10.compute(x, eps);

        return (((((log10 / log3) / ln) + log3) + (log5 * log3)) / ln);
    }
}
