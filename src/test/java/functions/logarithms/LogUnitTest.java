package functions.logarithms;

import functions.CsvOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogUnitTest {
    private Ln ln = new Ln();
    private Log3 log3 = new Log3(ln);
    private Log5 log5 = new Log5(ln);
    private Log10 log10 = new Log10(ln);
    private static CsvOutput csvOutput = new CsvOutput();

    private void runTest(LogarithmicFunction lf, String path, Double x, Double trueResult){
        csvOutput.setFilePath(path);
        try {
            double result = lf.compute(x, 0.001);
            csvOutput.logger(x, result);
            assertEquals(trueResult, result, 0.001);
        } catch (ArithmeticException e) {
            assertEquals("Wrong x", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/lnData.csv")
    void lnTest(Double x, Double trueResult) {
        runTest(ln,"src/test/resources/result/log/ln.csv", x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log3Data.csv")
    void log3Test(Double x, Double trueResult) {
        runTest(log3,"src/test/resources/result/log/log3.csv", x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log5Data.csv")
    void log5Test(Double x, Double trueResult) {
        runTest(log5, "src/test/resources/result/log/log5.csv", x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log10Data.csv")
    void log10Test(Double x, Double trueResult) {
        runTest(log10,"src/test/resources/result/log/log10.csv", x, trueResult);
    }
}
