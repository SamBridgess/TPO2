package functions.trigonometry;

import functions.CsvOutput;
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
    private static CsvOutput csvOutput = new CsvOutput();


    private void runTest(TrigonometryFunction tf, String path, Double divisible, Double divider, Double trueResult){
        csvOutput.setFilePath(path);
        double x = divisible * Math.PI / divider;
        try {
            double result = tf.compute(x, 0.001);
            csvOutput.logger(x, result);

            assertEquals(trueResult, result, 0.001);
        } catch (ArithmeticException e) {
            assertEquals("Wrong x", e.getMessage());
        }
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/sinData.csv")
    void sinTest(Double divisible, Double divider, Double trueResult) {
        runTest(sin, "src/test/resources/result/trig/sin.csv", divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cosData.csv")
    void cosTest(Double divisible, Double divider, Double trueResult) {
        runTest(cos, "src/test/resources/result/trig/cos.csv",  divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/tanData.csv")
    void tanTest(Double divisible, Double divider, Double trueResult) {
        runTest(tan, "src/test/resources/result/trig/tan.csv",  divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cotData.csv")
    void cotTest(Double divisible, Double divider, Double trueResult) {
        runTest(cot, "src/test/resources/result/trig/cot.csv",  divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/secData.csv")
    void secTest(Double divisible, Double divider, Double trueResult) {
        runTest(sec, "src/test/resources/result/trig/sec.csv",  divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cscData.csv")
    void cscTest(Double divisible, Double divider, Double trueResult) {
        runTest(csc, "src/test/resources/result/trig/csc.csv",  divisible, divider, trueResult);
    }
}
