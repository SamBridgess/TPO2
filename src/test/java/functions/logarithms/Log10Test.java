package functions.logarithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Log10Test {
    private static Log10 log10;

    @BeforeAll
    public static void init() {
        log10 = new Log10(new Ln());
    }

    @Test
    void testZeroLn() {
        assertEquals(0, log10.compute(1, 0.001));
    }

    @Test
    void testInvalidX() {
        assertThrows(ArithmeticException.class, () -> {
            log10.compute(-1, 0.001);
        });

        assertThrows(ArithmeticException.class, () -> {
            log10.compute(Double.NaN, 0.001);
        });
    }

    @Test
    void testNormalX() {
        assertAll(
                () -> assertEquals(1d, log10.compute(10, 0.001), 0.01),
                () -> assertEquals(1.1760, log10.compute(15, 0.001), 0.01)
        );
    }

}