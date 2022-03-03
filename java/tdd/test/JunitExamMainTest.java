import org.junit.*;

import static org.junit.Assert.*;

public class JunitExamMainTest {

    JunitExamMain jem;

    @Before
    public void setup() throws Exception{
        jem = new JunitExamMain(5);
        System.out.println("setup()...");
    }
    @BeforeClass
    public static void setupBeforeClass() throws Exception{
        System.out.println("setupBeforeClass()...");
    }

    @After
    public void teardown() throws Exception{
        System.out.println("teardowm()...");
    }

    @AfterClass
    public static void teardownAfterClass() throws Exception{
        System.out.println("teardownAfterClass()...");
    }


    @Test
    public void testAddWithNew(){
        System.out.println("testAddWithNew() start ...");
        assertEquals(jem.add(5),10);
        System.out.println("testAddWithNew() end ...");

    }



    @Test
    public void testAddWithoutNew(){
        System.out.println("testAddWithoutNew() start ...");
//        JunitExamMain jem = new JunitExamMain(5);
        assertEquals(jem.add(5),10);
        System.out.println("testAddWithoutNew() end ...");

    }
}