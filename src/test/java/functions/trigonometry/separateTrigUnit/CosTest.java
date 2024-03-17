package functions.trigonometry.separateTrigUnit;

import functions.trigonometry.Cos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.PI;

class CosTest {
    private static Cos cos;

    @BeforeAll
    public static void init() {
        cos = new Cos();
    }

    @Test
    void testCosValidX() {
        Assertions.assertAll(
                () -> assertFalse(cos.validX(Double.NaN)),
                () -> assertFalse(cos.validX(Double.NEGATIVE_INFINITY)),
                () -> assertFalse(cos.validX(Double.POSITIVE_INFINITY)),
                () -> assertFalse(cos.validX(0.000000001)),
                () -> assertTrue(cos.validX(0))
        );
    }

    @Test
    void testZeroCos() {
        assertAll(
                () -> assertEquals(cos.compute(-PI / 2, 0d), 0d),
                () -> assertEquals(cos.compute(-3 * PI / 2, 0d), 0d),
                () -> assertEquals(cos.compute(-9 * PI / 2, 0d), 0d)
        );
    }

    @Test
    void testNormalValues() {
        assertAll(
                () -> assertEquals(cos.compute(0, 0.1), 1, 0.1),
                () -> assertEquals(cos.compute(-PI, 0.001), -1, 0.001),
                () -> assertEquals(cos.compute(-5 * PI / 4, 0.001), Math.cos(-5 * PI / 4), 0.001),
                () -> assertEquals(cos.compute(-11 * PI / 6, 0.001), Math.cos(-11 * PI / 6), 0.001)
        );
    }

    @Test
    void testThrowArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            cos.compute(52, 0.1);
        });
    }

}