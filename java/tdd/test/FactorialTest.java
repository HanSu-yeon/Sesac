import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialTest {
    Factorial fac;

    @Before
    public void setup(){
        fac= new Factorial();
    }



    @Test
    public void shouldReturnOneWhenZeroIn(){
//        Factorial fac = new Factorial();  //정의되지 않은 클래스
        assertEquals( 1,fac.factorial(0)); //정의되지 않은 메서드
    }


    @Test
    public void shouldReturnOneWhenOneIn(){
//        Factorial fac = new Factorial();
        assertEquals(1,fac.factorial(0));
    }

    @Test
    public void shouldReturnTwoWhenTwoIn(){
        assertEquals(2,fac.factorial(2));
    }

    @Test
    public void 팩토리얼_3은_6(){
        assertEquals(6,fac.factorial(3));
    }

    @Test
    public void 팩토리얼_10은_3628800(){
        assertEquals(3628800,fac.factorial(10));
    }
    //음수인 경우
    @Test(expected = IllegalArgumentException.class)
    public void 팩토리얼_음수는_예외발생(){
        fac.factorial(-1);
    }
    //양수인 경우
    @Test
    public void 팩토리얼_0_또는_양수(){
        //{입력값, 출력값}
        int values[][] = {
                {0, 1}, {1, 1}, {2, 2}, {3, 6}, {10, 3628800}

        };
        for (int[] value: values){
            assertEquals(value[1],fac.factorial(value[0]));
        }
    }
}