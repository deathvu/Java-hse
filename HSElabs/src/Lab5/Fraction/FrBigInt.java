package Lab5.Fraction;

import Lab5.Interfaces.Add;
import Lab5.Interfaces.MyComparable;

import java.math.BigInteger;

public class FrBigInt implements MyComparable, Comparable, Add {
    private BigInteger nom;
    private BigInteger denom;

    private void adjust() {
        //BigInteger tmp = new BigInteger("0");

        if (nom.multiply(denom).compareTo(BigInteger.ZERO) > 0) {
            nom = nom.abs();
            denom = denom.abs();
        } else {
            nom = nom.abs().negate();
            denom = denom.abs();
        }
        if (nom.multiply(denom).equals(BigInteger.ZERO)) {
            nom = new BigInteger("0");
            denom = new BigInteger("1");
        }
        reduce();
    }

    private void reduce() {
        BigInteger a = nom.min(denom.abs());
        BigInteger tmp = new BigInteger("1");
        while (!a.equals(BigInteger.ONE) && !a.equals(BigInteger.ZERO)) {
            while (nom.mod(a).equals(BigInteger.ZERO) && denom.mod(a).equals(BigInteger.ZERO)) {
                nom = nom.divide(a);
                denom = denom.divide(a);
            }
            a = a.subtract(tmp);
        }
    }


    public void add(FrBigInt fr) {
        nom = nom.multiply(fr.denom).add(fr.nom.multiply(denom));
        denom = denom.multiply(fr.denom);
        adjust();
    }

    public void multiply(FrBigInt fr) {
        nom = nom.multiply(fr.nom);
        denom = denom.multiply(fr.denom);
        adjust();
    }

    public void divide(FrBigInt fr) {
        nom = nom.multiply(fr.denom);
        denom = denom.multiply(fr.nom);
        adjust();
    }


    /*   */

    @Override
    public Object addMore(Object[] o) {
        if(o instanceof FrBigInt[]){
            FrBigInt t = new FrBigInt();
            for (int i = 0; i < o.length; i++) {
                t.add((FrBigInt)o[i]);
            }
            return t;
        } else{
            System.out.println("data type mismatch");
            return null;
        }
    }

   /*   */

    public int compareTo(Object o) {
        if (o instanceof FrBigInt) {
            BigInteger a = this.nom.multiply(((FrBigInt) o).denom);
            BigInteger b = this.denom.multiply(((FrBigInt)o).nom);
            return a.compareTo(b);
        } else
            System.out.println("data type mismatch");
        return -123;
    }

    @Override
    public int myCompareTo(Object o) {
        return compareTo(o);
    }



    @Override
    public String toString() {
        if (denom.equals(BigInteger.ONE) == true) {
            return nom + "";
        } else {
            return nom + "/" + denom;
        }
    }



    FrBigInt(int a, int b) {
        nom = new BigInteger("" + a);
        denom = new BigInteger("" + b);
        adjust();

    }

    FrBigInt(int a) {
        this(a, 1);
    }

    FrBigInt() {
        this(0, 1);
    }

    FrBigInt(String f) {
        if (f.indexOf('/') != -1) {
            String nom = f.substring(0, f.indexOf('/'));
            String den = f.substring(f.indexOf('/') + 1);
            this.nom = new BigInteger(nom);
            this.denom = new BigInteger(den);
            adjust();
        } else {
            this.nom = new BigInteger(f);
            this.denom = new BigInteger("1");
            adjust();
        }
    }




    /*private static FrBigInt[] sort(FrBigInt[] a) {
        FrBigInt temp;
        FrBigInt[] f = a;
        for (int i = 0; i < f.length; i++) {
            for (int j = 1; j < (f.length - i); j++) {
                //if (f[j-1].compareTo(f[j]) == 1){
                if (f[j-1].myCompareTo(f[j]) == 0){
                    temp = f[j - 1];
                    f[j - 1] = f[j];
                    f[j] = temp;
                }
            }
        }
        return f;
    }*/
}

