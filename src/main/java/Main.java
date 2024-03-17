import functions.logarithms.*;
import functions.trigonometry.*;

public class Main {
    public static void main(String[] args) {
        Cos cos = new Cos();
        Sin sin = new Sin(cos);
        Tan tan = new Tan(cos, sin);
        Sec sec = new Sec(cos);
        Cot cot = new Cot(cos, sin);
        Csc csc = new Csc(sin);
        TrigonometricExpression trigonometricExpression = new TrigonometricExpression(sin, cos, tan, cot, sec, csc);

        Ln ln = new Ln();
        Log3 log3 = new Log3(ln);
        Log5 log5 = new Log5(ln);
        Log10 log10 = new Log10(ln);
        LogarithmicExpression logarithmicExpression = new LogarithmicExpression(ln, log3, log5, log10);

        double [] arr = {
                0.1,
                0.2,
                0.3,
                0.4,
                0.5,
                0.6,
                0.7,
                0.8,
                0.9,
                1.0,
                1.1,
                1.2,
                1.3,
                1.4,
                1.5,
                1.6,
                1.7,
                1.8,
                1.9,
                2.0,
        };
        for(int i = 0; i < arr.length; i++){
            double res = logarithmicExpression.calculate(arr[i], 0.001);
            //double res =  log10.compute(arr[i], 0.001);
            System.out.println(arr[i] + ", " + res);
        }

/*
        double[][] arr = {
                // {1, 1},
                {0.0, 1.0},
                {-1.0, 6.0},
                {-1.0, 4.0},
                {-1.0, 3.0},
                {-1.0, 2.0},
                {-2.0, 3.0},
                {-3.0, 4.0},
                {-5.0, 6.0},
                {-1.0, 1.0},
                {-7.0, 6.0},
                {-5.0, 4.0},
                {-4.0, 3.0},
                {-3.0, 2.0},
                {-5.0, 3.0},
                {-7.0, 4.0},
                {-11.0, 6.0},
                {1.0, 1.0}
        };



        for(int i = 0; i < arr.length; i++){
            double res = trigonometricExpression.calculate(arr[i][0]*Math.PI/arr[i][1], 0.001);
            //double res =  cos.compute(arr[i][0]*Math.PI/arr[i][1], 0.001);
            System.out.println(arr[i][0] + ", " + arr[i][1] + ", " + res);
        }
         */
    }
}