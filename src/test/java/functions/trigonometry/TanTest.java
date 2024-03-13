package functions.trigonometry;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Math.PI;

class TanTest {
    private static Tan tan;

    @BeforeAll
    public static void init() {
        Cos cos = new Cos();
        tan = new Tan(cos, new Sin(cos));
    }

    @Test
    void testInfinities() {
        assertAll(
                () -> assertEquals(POSITIVE_INFINITY, tan.compute(-3 * PI / 2, 0.001)),
                () -> assertEquals(NEGATIVE_INFINITY, tan.compute(-PI / 2, 0.001))
        );
    }

    @Test
    void testZeroTan() {
        assertAll(
                () -> assertEquals(0, tan.compute(0, 0.001), Double.MIN_NORMAL),
                () -> assertEquals(0, tan.compute(-PI, 0.001), Double.MIN_NORMAL)
        );
    }

    @Test
    void testNormalTan() {
        assertAll(
                () -> assertEquals(Math.tan(-5 * PI / 4), tan.compute(-5 * PI / 4, 0.001), 0.01),
                () -> assertEquals(Math.tan(-5 * PI / 6), tan.compute(-5 * PI / 6, 0.001), 0.01),
                () -> assertEquals(Math.tan(-8 * PI / 3), tan.compute(-8 * PI / 3, 0.001), 0.01)
        );
    }

    @Test
    void testThrowArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            tan.compute(52, 0.1);
        });
    }

}