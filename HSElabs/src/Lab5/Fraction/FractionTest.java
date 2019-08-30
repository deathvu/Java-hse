package Lab5.Fraction;

import org.junit.*;


public class FractionTest {
    private static long startTime = 0;
    private static long stopTime = 0;
    private static long result = 0;
    private static Fraction f = new Fraction(1,2);
    private static Fraction f1 = new Fraction(1,2);
    private static Fraction[] fArr = new Fraction[2];

    @BeforeClass
    public static void beforeClass(){
        startTime = System.currentTimeMillis();
    }

    @AfterClass
    public static void afterClass(){
        stopTime = System.currentTimeMillis();
        result = stopTime-startTime;
        System.out.println("Test has ended in : "+result+" millis");
    }


    @Before
    public void initFr(){
        fArr[0] = f;
        fArr[1]= f1;
    }

    @Test
    public void testAdd(){
        System.out.println("Test of method 'add'");
        Assert.assertEquals(new Fraction(1),f.add(f1));
    }

    @Test
    public void testDiv(){
        System.out.println("Test of method 'division'");
        Assert.assertEquals(new Fraction(0),Fraction.divMore(fArr));
    }

    @Test(expected = NullPointerException.class)
    public void testSub(){
        System.out.println("Test of method 'Sub'");
        Assert.assertEquals(new Fraction(1),Fraction.subMore(fArr));
    }

    @Test
    public void testMult(){
        System.out.println("Test of method 'mult'");
        Assert.assertEquals(Fraction.multMore(fArr),"1/4");
    }
}
