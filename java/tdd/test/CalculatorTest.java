import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void sum() {
        Calculator cal = new Calculator();
        assertEquals(cal.sum(10,20),30);
    }
}