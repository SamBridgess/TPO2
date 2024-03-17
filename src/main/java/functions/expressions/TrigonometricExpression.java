package functions.expressions;

import functions.trigonometry.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TrigonometricExpression implements Expression {
    private final Sin sin;
    private final Cos cos;
    private final Tan tan;
    private final Cot cot;
    private final Sec sec;
    private final Csc csc;


    @Override
    public double calculate(double x, double eps) {
        double cos = this.cos.compute(x, eps);
        double tan = this.tan.compute(x, eps);
        double cot = this.cot.compute(x, eps);
        double csc = this.csc.compute(x, eps);
        double sec = this.sec.compute(x, eps);
        double sin = this.sin.compute(x, eps);

        return ((((((((((Math.pow((((cos / cot) + cos) / csc), 3) * (tan - cos)) - (cot + sec)) * csc) / sec) - Math.pow(tan, 2)) - cot)
                - ((Math.pow(sin, 3) / (cot + cot)) - cos)) - Math.pow(((csc + sec) / (((csc * cos) / (Math.pow((sin - sec), 3) - sin))
                * (((Math.pow(csc, 2) + (csc * ((sec * cos) * (sin + tan)))) - (cos + (sin / (cos + sec)))) + (sin / cos)))), 3)) + (((csc * sin)
                + (Math.pow(cos, 2) * cot)) - (Math.pow(cot, 3) * (sin / (sin / sin))))) + cos);
    }
}
