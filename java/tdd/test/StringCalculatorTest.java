import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StringCalculatorTest {

    @Test
    public void testStringCalculator() {
        assertEquals(2, StringCalculator.add("2"));
        assertEquals(2 + 3, StringCalculator.add("2,3"));
        assertEquals(2 + 3 + 6, StringCalculator.add("2,3,6"));
    }

    @Test
    public void test_빈문자열은_0을_반환() {
        assertEquals(0, StringCalculator.add(""));
        assertEquals(0, StringCalculator.add("    "));
        assertEquals(0, StringCalculator.add("  "));
    }

    @Test
    public void test_구분문자로_개행문자도_허용() {
        assertEquals(2 + 3, StringCalculator.add("2\n3"));
        assertEquals(2 + 3 + 6, StringCalculator.add("2\n3,6"));
    }

    @Test
    public void test_다양한_구분문자_허용() {
        assertEquals(2 + 3 + 6, StringCalculator.add("//;\n2;3;6"));
        assertEquals(2 + 3 + 6, StringCalculator.add("//#:#\n2#:#3#:#6"));
    }

    @Test(expected=RuntimeException.class)
    public void test_음수가_포함된_경우_예외발생(){
        StringCalculator.add("3,-3,-15,15");
    }

    @Test
    public void test_음수가_포함된_경우_예외메시지_제공() {
        RuntimeException re = null;
        try {
            StringCalculator.add("3,-3,-15,15");
        } catch (RuntimeException e) {
            re = e;
        }
        assertNotNull(re);
        assertEquals("Negative not allowed : [-3, -15]", re.getMessage());
    }

    @Test
    public void test_1000이상인_숫자는_계산에서_제외(){
        assertEquals(0,StringCalculator.add("1000,1001,1002"));
        assertEquals(2,StringCalculator.add("2,1001,1002"));
        assertEquals(7,StringCalculator.add("2,1001,5"));
    }

    }