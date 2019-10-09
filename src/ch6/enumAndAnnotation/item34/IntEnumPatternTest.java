package ch6.enumAndAnnotation.item34;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.RoundingMode;

@RunWith(JUnit4.class)
public class IntEnumPatternTest {

    @Test
    public void test1() {
        boolean b = IntEnumPattern.APPLE_FUJI == IntEnumPattern.ORANGE_NAVEL;
        System.out.println(IntEnumPattern.APPLE_FUJI);
        System.out.println(IntEnumPattern.ORANGE_NAVEL);

        RoundingMode.values();
    }
}
