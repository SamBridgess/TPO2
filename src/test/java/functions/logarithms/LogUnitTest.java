package functions.logarithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogUnitTest {
    private Ln ln = new Ln();
    private Log3 log3 = new Log3(ln);
    private Log5 log5 = new Log5(ln);
    private Log10 log10 = new Log10(ln);

    private void runTest(LogarithmicFunction lf, Double x, Double trueResult){
        try {
            double result = lf.compute(x, 0.001);
            assertEquals(trueResult, result, 0.001);
        } catch (ArithmeticException e) {
            assertEquals("Wrong x", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/lnData.csv")
    void lnTest(Double x, Double trueResult) {
        runTest(ln, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log3Data.csv")
    void log3Test(Double x, Double trueResult) {
        runTest(log3, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log5Data.csv")
    void log5Test(Double x, Double trueResult) {
        runTest(log5, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log10Data.csv")
    void log10Test(Double x, Double trueResult) {
        runTest(log10, x, trueResult);
    }
}
