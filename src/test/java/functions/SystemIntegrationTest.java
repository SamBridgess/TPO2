package functions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import functions.logarithms.LogarithmicExpression;
import functions.trigonometry.TrigonometricExpression;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SystemIntegrationTest {
    private TrigonometricExpression trigonometricExpression = Mockito.mock(TrigonometricExpression.class);
    private LogarithmicExpression logarithmicExpression = Mockito.mock(LogarithmicExpression.class);

    @BeforeAll
    public void fillAll(){
        fillMock(trigonometricExpression, "src/test/resources/inputTrig/trigFuncData.csv");
        fillMock(logarithmicExpression, "src/test/resources/inputLog/logFuncData.csv");
    }

    private void fillMock(Expression expression, String path){
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                final double x = Double.parseDouble(record[0]);
                final double y = Double.parseDouble(record[1]);
                when(expression.calculate(x, anyDouble())).thenReturn(y);
            }
        } catch (IOException | CsvException ignored) {
        }
    }
}
