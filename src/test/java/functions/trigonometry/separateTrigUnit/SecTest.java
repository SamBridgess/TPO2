package functions.trigonometry.separateTrigUnit;

import functions.trigonometry.Cos;
import functions.trigonometry.Sec;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

class SecTest {
    private static Sec sec;

    @BeforeAll
    public static void init() {
        sec = new Sec(new Cos());
    }

    @Test
    void testInfinities() {
        assertAll(
                () -> assertEquals(POSITIVE_INFINITY, sec.compute(-PI / 2, 0.001)),
                () -> assertEquals(POSITIVE_INFINITY, sec.compute(-3 * PI / 2, 0.001))
        );
    }

    @Test
    void testNormalSec() {
        assertAll(
                () -> assertEquals(1 / Math.cos(-5 * PI / 4), sec.compute(-5 * PI / 4, 0.001), 0.01),
                () -> assertEquals(1 / Math.cos(-5 * PI / 6), sec.compute(-5 * PI / 6, 0.001), 0.01),
                () -> assertEquals(1 / Math.cos(-8 * PI / 3), sec.compute(-8 * PI / 3, 0.001), 0.01)
        );
    }

    @Test
    void testThrowArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            sec.compute(52, 0.1);
        });
    }

}