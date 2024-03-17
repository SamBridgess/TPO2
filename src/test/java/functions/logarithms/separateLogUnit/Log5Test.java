package functions.logarithms.separateLogUnit;

import functions.logarithms.Ln;
import functions.logarithms.Log5;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Log5Test {
    private static Log5 log5;

    @BeforeAll
    public static void init() {
        log5 = new Log5(new Ln());
    }

    @Test
    void testZeroLn() {
        assertEquals(0, log5.compute(1, 0.001));
    }

    @Test
    void testInvalidX() {
        assertThrows(ArithmeticException.class, () -> {
            log5.compute(-1, 0.001);
        });

        assertThrows(ArithmeticException.class, () -> {
            log5.compute(Double.NaN, 0.001);
        });
    }

    @Test
    void testNormalX() {
        assertAll(
                () -> assertEquals(1.4306, log5.compute(10, 0.001), 0.01),
                () -> assertEquals(1.6826, log5.compute(15, 0.001), 0.01)
        );
    }

}