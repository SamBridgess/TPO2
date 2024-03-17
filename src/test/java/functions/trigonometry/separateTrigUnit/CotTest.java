package functions.trigonometry.separateTrigUnit;

import functions.trigonometry.Cos;
import functions.trigonometry.Cot;
import functions.trigonometry.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

class CotTest {
    private static Cot cot;

    @BeforeAll
    public static void init() {
        Cos cos = new Cos();
        cot = new Cot(cos, new Sin(cos));
    }

    @Test
    void testInfinities() {
        assertAll(
                () -> assertEquals(POSITIVE_INFINITY, cot.compute(0, 0.001)),
                () -> assertEquals(NEGATIVE_INFINITY, cot.compute(-PI, 0.001))
        );
    }

    @Test
    void testZeroCot() {
        assertAll(
                () -> assertEquals(0, cot.compute(-3 * PI / 2, 0.001), Double.MIN_NORMAL),
                () -> assertEquals(0, cot.compute(-PI / 2, 0.001), Double.MIN_NORMAL)
        );
    }

    @Test
    void testNormalCot() {
        assertAll(
                () -> assertEquals(1 / Math.tan(-5 * PI / 4), cot.compute(-5 * PI / 4, 0.001), 0.01),
                () -> assertEquals(1 / Math.tan(-5 * PI / 6), cot.compute(-5 * PI / 6, 0.001), 0.01),
                () -> assertEquals(1 / Math.tan(-8 * PI / 3), cot.compute(-8 * PI / 3, 0.001), 0.01)
        );
    }

    @Test
    void testThrowArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            cot.compute(52, 0.1);
        });
    }

}