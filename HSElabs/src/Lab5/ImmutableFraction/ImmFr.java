package Lab5.ImmutableFraction;

import Lab5.Fraction.Fraction;

import java.util.HashSet;
import java.util.Objects;


public class ImmFr {
    private final int num;
    private final int denom;
    private static HashSet<ImmFr> cache = new HashSet<>();

    ImmFr(int n, int d) {
        int divisor = Math.min(Math.abs(n), Math.abs(d));
        while (divisor != 1 && divisor != 0) {
            while (n % divisor == 0 && d % divisor == 0) {
                n /= divisor;
                d /= divisor;
            }
            divisor = divisor - 1;
        }
        if (n * d > 0) {
            n = Math.abs(n);
            d = Math.abs(d);
        } else {
            n = -Math.abs(n);
            d = Math.abs(d);
        }
        if (n * d == 0) {
            n = 0;
            d = 1;
        }


        this.num = n;
        this.denom = d;
    }


    public static ImmFr getImmFr(int n,int d){
       ImmFr fr = new ImmFr(n,d);
        if (cache.contains(fr)==true){
           return fr;
       }else {
           cache.add(fr);
           return fr;
       }
    }


    public static void main(String[] args) {
        ImmFr fr1 = new ImmFr(1,6);
        ImmFr fr2 = ImmFr.getImmFr(1,6);
    }
}








