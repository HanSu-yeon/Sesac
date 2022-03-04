import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie;

    @Before
    public void setup(){
     movie = new Movie();

    }


    @Test
    public void 등급을_설정하지_않은_상태에서는_평균등급으로_0을_반환(){
       assertEquals(0,movie.averateRate());
    }

    @Test
    public void 등급으로_1을_설정하면_평균등급_1을_반환(){
        movie.rate(1);
        assertEquals(1, movie.averateRate());

    }

    @Test
    public void 등급으로_3_5를_설정하면_평균등급으로_4를_반환(){
        movie.rate(3);
        movie.rate(5);
        assertEquals(4, movie.averateRate());
    }
}