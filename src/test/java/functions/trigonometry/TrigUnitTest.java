package functions.trigonometry;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigUnitTest {
    private Cos cos = new Cos();
    private Sin sin = new Sin(cos);
    private Tan tan = new Tan(cos, sin);
    private Sec sec = new Sec(cos);
    private Cot cot = new Cot(cos, sin);
    private Csc csc = new Csc(sin);

    private void runTest(TrigonometryFunction tf, Double divisible, Double divider, Double trueResult){
        double x = divisible * Math.PI / divider;
        try {
            double result = tf.compute(x, 0.001);
            assertEquals(trueResult, result, 0.001);
        } catch (ArithmeticException e) {
            assertEquals("Wrong x", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/sinData.csv")
    void sinTest(Double divisible, Double divider, Double trueResult) {
        runTest(sin, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cosData.csv")
    void cosTest(Double divisible, Double divider, Double trueResult) {
        runTest(cos, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/tanData.csv")
    void tanTest(Double divisible, Double divider, Double trueResult) {
        runTest(tan, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cotData.csv")
    void cotTest(Double divisible, Double divider, Double trueResult) {
        runTest(cot, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/secData.csv")
    void secTest(Double divisible, Double divider, Double trueResult) {
        runTest(sec, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cscData.csv")
    void cscTest(Double divisible, Double divider, Double trueResult) {
        runTest(csc, divisible, divider, trueResult);
    }
}
