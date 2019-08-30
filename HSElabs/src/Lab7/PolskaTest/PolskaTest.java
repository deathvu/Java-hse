package Lab7.PolskaTest;

import Lab5.Fraction.Fraction;
import org.junit.*;

import static org.junit.Assert.*;

public class PolskaTest {
    private String st, st1, st2, st3 = new String();


    @Test
    public void evaluationMeth() {
        st = "1/2+1/2";
        assertEquals(new Fraction(1),Polska.evaluation(st));
    }

    @Test(expected = Exception.class)
    public void evaluationExcep() {
        st = "1/2:0";
        assertEquals(Polska.evaluation(st), 12);
    }
}
