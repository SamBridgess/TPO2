package functions.trigonometry.separateTrigUnit;

import functions.trigonometry.Cos;
import functions.trigonometry.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

class SinTest {
    private static Sin sin;

    @BeforeAll
    static void init() {
        sin = new Sin(new Cos());
    }

    @Test
    void testThrowArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            sin.compute(Double.NaN, 0d);
        });
    }

    @Test
    void testZeroSin() {
        assertAll(
                () -> assertEquals(sin.compute(0d, 0d), 0d),
                () -> assertEquals(sin.compute(-PI, 0d), 0d),
                () -> assertEquals(sin.compute(-10 * PI, 0.001), 0d, 0.001)
        );
    }

    @Test
    void testNormalValues() {
        assertAll(
                () -> assertEquals(sin.compute(-PI / 6, 0.001), Math.sin(-PI / 6), 0.001),
                () -> assertEquals(sin.compute(-4 * PI / 3, 0.001), Math.sin(-4 * PI / 3), 0.001),
                () -> assertEquals(sin.compute(-7 * PI / 4, 0.001), Math.sin(-7 * PI / 4), 0.001)
        );
    }

}