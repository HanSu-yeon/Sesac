import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordCheckerTest {


    @Ignore
    public void testPasswordChecker() {
        // 제어문자
        assertFalse(PasswordChecker.checker(""));
        assertFalse(PasswordChecker.checker("    ")); // space
        assertFalse(PasswordChecker.checker("	")); // tab
        assertFalse(PasswordChecker.checker("\n"));
        assertFalse(PasswordChecker.checker("\t"));

        // 허용문자
//		assertTrue(PasswordChecker.checker("a"));
//		assertTrue(PasswordChecker.checker("A"));
//		assertTrue(PasswordChecker.checker("1"));
//		assertTrue(PasswordChecker.checker("!"));
//		assertTrue(PasswordChecker.checker("@"));
//		assertTrue(PasswordChecker.checker("#"));
//		assertTrue(PasswordChecker.checker("%"));
//		assertTrue(PasswordChecker.checker("^"));
//		assertTrue(PasswordChecker.checker("&"));
//		assertTrue(PasswordChecker.checker("*"));
    }

    @Ignore
    public void test_반드시_영문자로_시작() {
        assertTrue(PasswordChecker.checker("a1@"));
        assertFalse(PasswordChecker.checker("1a@"));
        assertFalse(PasswordChecker.checker("@1a"));
    }

    @Ignore
    public void test_허용문자종류_2개이상조합() {
        assertTrue(PasswordChecker.checker("a1"));
        assertTrue(PasswordChecker.checker("a@"));
        assertTrue(PasswordChecker.checker("a1@"));
        assertFalse(PasswordChecker.checker("a"));
    }

    @Test
    public void test_허용문자종류_2개이상_조합() {
        assertFalse(PasswordChecker.checker("a234567"));
        assertFalse(PasswordChecker.checker("a2345678"));
        assertTrue(PasswordChecker.checker("a234567890"));

        assertFalse(PasswordChecker.checker("a@34567"));
        assertTrue(PasswordChecker.checker("a@345678"));
        assertTrue(PasswordChecker.checker("a@34567890"));
    }

    @Test(expected = RuntimeException.class)
    public void test_허용되지_않은_문자열_포함() {
        PasswordChecker.checker("    ");
    }

    @Test
    public void test_허용되지_않은_문자열_포함_오류메시지() {
        RuntimeException re = null;
        try {
            PasswordChecker.checker("    ");
        } catch(RuntimeException e) {
            re = e;
        }
        assertEquals("허용되지 않는 문자열이 포함되어 있습니다.", re.getMessage());
    }

}