package functions.trigonometry;

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

public class TrigIntegrationTest {
    public static Sin sin = Mockito.mock(Sin.class);
    public static Cos cos = Mockito.mock(Cos.class);
    public static Tan tan = Mockito.mock(Tan.class);
    public static Cot cot = Mockito.mock(Cot.class);
    public static Sec sec = Mockito.mock(Sec.class);
    public static Csc csc = Mockito.mock(Csc.class);

    @BeforeAll
    public static void fillAll(){
        fillMock(sin, "src/test/resources/inputTrig/sinData.csv");
        fillMock(cos, "src/test/resources/inputTrig/cosData.csv");
        fillMock(tan, "src/test/resources/inputTrig/tanData.csv");
        fillMock(cot, "src/test/resources/inputTrig/cotData.csv");
        fillMock(sec, "src/test/resources/inputTrig/secData.csv");
        fillMock(csc, "src/test/resources/inputTrig/cscData.csv");
    }
    private static void fillMock(TrigonometryFunction tf, String path){
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            List<String[]> lines = csvReader.readAll();
            for (String[] line : lines) {
                double x = Double.parseDouble(line[0]);
                double y = Double.parseDouble(line[1]);
                double res = Double.parseDouble(line[2]);

                Mockito.when(tf.compute(x*Math.PI/y, 0.001)).thenReturn(res);
            }
        } catch (IOException e) {
            System.out.println("io");
        } catch (CsvException e) {
            System.out.println("csv");
        }
    }

    private void runTest(TrigonometricExpression te, Double divisible, Double divider, Double trueResult){
        double x = divisible * Math.PI / divider, result;
        try{
            result = te.calculate(x, 0.001);
            assertEquals(trueResult, result, 0.001);
        } catch (ArithmeticException e){
            assertEquals("Wrong x", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void allMockTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(sin, cos, tan, cot, sec, csc);
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void sinTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(new Sin(cos), cos, tan, cot, sec, csc);
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void sinFullTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(new Sin(new Cos()), cos, tan, cot, sec, csc);
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void cosTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(sin, new Cos(), tan, cot, sec, csc);
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void tanTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(sin, cos, new Tan(cos, sin), cot, sec, csc);
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void tanFullTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(sin, cos, new Tan(new Cos(), new Sin(new Cos())), cot, sec, csc);
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void cotTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(sin, cos, tan, new Cot(cos, sin), sec, csc);
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void cotFullTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(sin, cos, tan, new Cot(new Cos(), new Sin(new Cos())), sec, csc);
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void secTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(sin, cos, tan, cot, new Sec(cos), csc);
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void secFullTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(sin, cos, tan, cot, new Sec(new Cos()), csc);
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void cscTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(sin, cos, tan, cot, sec, new Csc(sin));
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void cscFullTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(sin, cos, tan, cot, sec, new Csc(new Sin(new Cos())));
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/trigFuncData.csv")
    void fullTest(Double divisible, Double divider, Double trueResult){
        TrigonometricExpression trigonometricExpression
                = new TrigonometricExpression(new Sin(new Cos()), new Cos(), new Tan(new Cos(), new Sin(new Cos())), new Cot(new Cos(), new Sin(new Cos())), new Sec(new Cos()), new Csc(new Sin(new Cos())));
        runTest(trigonometricExpression, divisible, divider, trueResult);
    }
}