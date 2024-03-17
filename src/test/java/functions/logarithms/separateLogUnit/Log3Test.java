package functions.logarithms.separateLogUnit;

import functions.logarithms.Ln;
import functions.logarithms.Log3;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Log3Test {
    private static Log3 log3;

    @BeforeAll
    public static void init() {
        log3 = new Log3(new Ln());
    }

    @Test
    void testZeroLn() {
        assertEquals(0, log3.compute(1, 0.001));
    }

    @Test
    void testInvalidX() {
        assertThrows(ArithmeticException.class, () -> {
            log3.compute(-1, 0.001);
        });

        assertThrows(ArithmeticException.class, () -> {
            log3.compute(Double.NaN, 0.001);
        });
    }

    @Test
    void testNormalX() {
        assertAll(
                () -> assertEquals(2.0959, log3.compute(10, 0.001), 0.01),
                () -> assertEquals(2.4649, log3.compute(15, 0.001), 0.01)
        );
    }

}