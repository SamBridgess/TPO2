package functions.trigonometry.separateTrigUnit;

import functions.trigonometry.Cos;
import functions.trigonometry.Csc;
import functions.trigonometry.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

class CscTest {
    private static Csc csc;

    @BeforeAll
    public static void init() {
        csc = new Csc(new Sin(new Cos()));
    }

    @Test
    void testInfinities() {
        assertAll(
                () -> assertEquals(POSITIVE_INFINITY, csc.compute(0, 0.001)),
                () -> assertEquals(POSITIVE_INFINITY, csc.compute(-PI, 0.001))
        );
    }

    @Test
    void testNormalCsc() {
        assertAll(
                () -> assertEquals(1 / Math.sin(-5 * PI / 4), csc.compute(-5 * PI / 4, 0.001), 0.01),
                () -> assertEquals(1 / Math.sin(-5 * PI / 6), csc.compute(-5 * PI / 6, 0.001), 0.01),
                () -> assertEquals(1 / Math.sin(-8 * PI / 3), csc.compute(-8 * PI / 3, 0.001), 0.01)
        );
    }

    @Test
    void testThrowArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            csc.compute(52, 0.1);
        });
    }

}