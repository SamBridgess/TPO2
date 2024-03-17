package functions.logarithms;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogIntegrationTest {
    private static Ln ln = Mockito.mock(Ln.class);
    private static Log3 log3 = Mockito.mock(Log3.class);
    private static Log5 log5 = Mockito.mock(Log5.class);
    private static Log10 log10 = Mockito.mock(Log10.class);

    @BeforeAll
    public static void fillAll(){
        fillMock(ln, "src/test/resources/inputLog/lnData.csv");
        fillMock(log3, "src/test/resources/inputLog/log3Data.csv");
        fillMock(log5, "src/test/resources/inputLog/log5Data.csv");
        fillMock(log10, "src/test/resources/inputLog/log10Data.csv");
    }

    private static void fillMock(LogarithmicFunction lf, String path) {
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            List<String[]> lines = csvReader.readAll();
            for (String[] line : lines) {
                final double x = Double.parseDouble(line[0]);
                final double res = Double.parseDouble(line[1]);

                Mockito.when(lf.compute(x, 0.001)).thenReturn(res);
            }
        } catch (IOException e) {
            System.out.println("io");
        } catch (CsvException e) {
            System.out.println("csv");
        }
    }

    private void runTest(LogarithmicExpression le, Double x, Double trueResult){
        try {
            double result = le.calculate(x, 0.001);
            assertEquals(trueResult, result, 0.001);
        } catch (ArithmeticException e) {
            assertEquals("Wrong x", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/logFuncData.csv")
    void allMockTest(Double x, Double trueResult) {
        LogarithmicExpression logarithmicExpression
                = new LogarithmicExpression(ln, log3, log5, log10);
        runTest(logarithmicExpression, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/logFuncData.csv")
    void lnTest(Double x, Double trueResult) {
        LogarithmicExpression logarithmicExpression
                = new LogarithmicExpression(new Ln(), log3, log5, log10);
        runTest(logarithmicExpression, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/logFuncData.csv")
    void log3Test(Double x, Double trueResult) {
        LogarithmicExpression logarithmicExpression
                = new LogarithmicExpression(ln, new Log3(ln), log5, log10);
        runTest(logarithmicExpression, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/logFuncData.csv")
    void log3FullTest(Double x, Double trueResult) {
        LogarithmicExpression logarithmicExpression
                = new LogarithmicExpression(ln, new Log3(new Ln()), log5, log10);
        runTest(logarithmicExpression, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/logFuncData.csv")
    void log5Test(Double x, Double trueResult) {
        LogarithmicExpression logarithmicExpression
                = new LogarithmicExpression(ln, log3, new Log5(ln), log10);
        runTest(logarithmicExpression, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/logFuncData.csv")
    void log5FullTest(Double x, Double trueResult) {
        LogarithmicExpression logarithmicExpression
                = new LogarithmicExpression(ln, log3, new Log5(new Ln()), log10);
        runTest(logarithmicExpression, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/logFuncData.csv")
    void log10Test(Double x, Double trueResult) {
        LogarithmicExpression logarithmicExpression
                = new LogarithmicExpression(ln, log3, log5, new Log10(ln));
        runTest(logarithmicExpression, x, trueResult);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/logFuncData.csv")
    void log10FullTest(Double x, Double trueResult) {
        LogarithmicExpression logarithmicExpression
                = new LogarithmicExpression(ln, log3, log5, new Log10(new Ln()));
        runTest(logarithmicExpression, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/logFuncData.csv")
    void fullTest(Double x, Double trueResult) {
        LogarithmicExpression logarithmicExpression
                = new LogarithmicExpression(new Ln(), new Log3(new Ln()), new Log5(new Ln()), new Log10(new Ln()));
        runTest(logarithmicExpression, x, trueResult);
    }
}
