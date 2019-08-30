package PolskaTest;

import org.junit.*;

import static org.junit.Assert.*;

public class PolskaTest {
    private static long startTime = 0;
    private static long stopTime = 0;
    private static long result = 0;
    private String st,st1,st2,st3 = new String();

    @BeforeClass
    public static void beforeClass(){
        startTime = System.currentTimeMillis();
    }
    @AfterClass
    public static void afterClass(){
        stopTime = System.currentTimeMillis();
        result = stopTime-startTime;
        System.out.println("Test has ended in :"+result+" millis");
    }


    @Test
    public void evaluation() {
        st = "(1+2)*12-(4:2)";
        st1 = "1+2*2:2";
        assertEquals(Polska.evaluation(st),34);
    }
}
