package functions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import functions.expressions.FunctionSystem;
import functions.expressions.LogarithmicExpression;
import functions.expressions.TrigonometricExpression;
import functions.logarithms.*;
import functions.trigonometry.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SystemIntegrationTest {
    private TrigonometricExpression trigonometricExpression = Mockito.mock(TrigonometricExpression.class);
    private LogarithmicExpression logarithmicExpression = Mockito.mock(LogarithmicExpression.class);
    private CsvOutput csvOutput = new CsvOutput();
    @BeforeAll
    public void fillAll(){
        fillMock(trigonometricExpression, "src/test/resources/inputTrig/trigFuncData.csv");
        fillMock(logarithmicExpression, "src/test/resources/inputLog/logFuncData.csv");
    }

    private void fillMock(TrigonometricExpression tf, String path) {
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                double divisible = Double.parseDouble(record[0]);
                double divider = Double.parseDouble(record[1]);
                double res = Double.parseDouble(record[2]);

                when(tf.calculate(divisible * Math.PI / divider, 0.001)).thenReturn(res);
            }
        } catch (IOException e) {
            System.out.println("io");
        } catch (CsvException e) {
            System.out.println("csv");
        }
    }

    private void fillMock(LogarithmicExpression le, String path) {
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            List<String[]> lines = csvReader.readAll();
            for (String[] line : lines) {
                double x = Double.parseDouble(line[0]);
                double res = Double.parseDouble(line[1]);

                Mockito.when(le.calculate(x, 0.001)).thenReturn(res);
            }
        } catch (IOException e) {
            System.out.println("io");
        } catch (CsvException e) {
            System.out.println("csv");
        }
    }

    private void runTest(FunctionSystem functionSystem, Double x, Double trueResult){
        csvOutput.setFilePath("src/test/resources/result/FuncSystem.csv");
        try {
            double result = functionSystem.calculate(x, 0.001);
            csvOutput.logger(x, result);
            assertEquals(trueResult, result, 0.001);
        } catch (ArithmeticException e) {
            assertEquals("Wrong x", e.getMessage());
        }
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/calcData.csv")
    void allMockTest(Double x, Double trueResult) {
        FunctionSystem functionSystem
                = new FunctionSystem(logarithmicExpression, trigonometricExpression);

        runTest(functionSystem, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calcData.csv")
    void logTest(Double x, Double trueResult) {
        LogarithmicExpression le =
                new LogarithmicExpression(new Ln(), new Log3(new Ln()), new Log5(new Ln()), new Log10(new Ln()));
        FunctionSystem functionSystem = new FunctionSystem(le, trigonometricExpression);

        runTest(functionSystem, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calcData.csv")
    void trigTest(Double x, Double trueResult) {
        TrigonometricExpression te
                = new TrigonometricExpression(new Sin(new Cos()), new Cos(), new Tan(new Cos(), new Sin(new Cos())), new Cot(new Cos(), new Sin(new Cos())), new Sec(new Cos()), new Csc(new Sin(new Cos())));
        FunctionSystem functionSystem = new FunctionSystem(logarithmicExpression, te);

        runTest(functionSystem, x, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calcData.csv")
    void fullTest(Double x, Double trueResult) {
        LogarithmicExpression le =
                new LogarithmicExpression(new Ln(), new Log3(new Ln()), new Log5(new Ln()), new Log10(new Ln()));
        TrigonometricExpression te
                = new TrigonometricExpression(new Sin(new Cos()), new Cos(), new Tan(new Cos(), new Sin(new Cos())), new Cot(new Cos(), new Sin(new Cos())), new Sec(new Cos()), new Csc(new Sin(new Cos())));
        FunctionSystem functionSystem = new FunctionSystem(le, te);

        runTest(functionSystem, x, trueResult);
    }
}
