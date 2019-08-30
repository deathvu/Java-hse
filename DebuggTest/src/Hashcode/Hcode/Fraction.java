package Hashcode.Hcode;

import java.util.Objects;

public class Fraction implements  Comparable<Fraction> {
    private int num;
    private int denom;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private void adjust() {
        if (num * denom > 0) {
            num = Math.abs(num);
            denom = Math.abs(denom);
        } else {
            num = -Math.abs(num);
            denom = Math.abs(denom);
        }
        if (num * denom == 0) {
            num = 0;
            denom = 1;
        }
    }

    private void reduce() {
        int divisor = Math.min(Math.abs(num), Math.abs(denom));
        while (divisor != 1 && divisor != 0) {
            while (num % divisor == 0 && denom % divisor == 0) {
                num /= divisor;
                denom /= divisor;
            }
            divisor = divisor - 1;
        }
    }

    public void print() {
        if (denom == 1) {
            System.out.println(num);
        } else {
            System.out.println(num + "/" + denom);
        }
    }

    public void add(Fraction f) {
        num = num * f.denom + f.num * denom;
        denom = denom * f.denom;
        reduce();
    }

    public void mult(Fraction f) {
        num = f.num * num;
        denom = f.denom * f.denom;
        reduce();
    }

    public void div(Fraction f) {
        num = num * f.denom;
        denom = denom * f.num;
        reduce();
    }

    public void sub(Fraction f) {
        num = num * f.denom - f.num * denom;
        denom = denom * f.denom;
        reduce();
    }

    public void pow(int exponent) {
        num = (int) Math.pow(num, exponent);
        denom = (int) Math.pow(denom, exponent);
        reduce();
    }

    public Fraction stanAddMore(Fraction[] a){
        Fraction result = new Fraction(0);
        for(int i = 0;i<a.length;i++){
            result.add(a[i]);
        }
        return result;
    }

    public Fraction multMore(Fraction[] a){
        Fraction result = new Fraction(1);
        for(int i = 0;i<a.length;i++){
            result.mult(a[i]);
        }
        return result;
    }

    public Fraction divMore(Fraction[] a){
        Fraction result = new Fraction(1);
        for(int i = 0;i<a.length;i++){
            result.div(a[i]);
        }
        return result;
    }

    public Fraction subMore(Fraction[] a){
        Fraction result = new Fraction(0);
        for(int i = 0; i<a.length;i++){
            result.sub(a[i]);
        }
        return result;
    }

    public Object addMore(Object[] o) {
        if(o instanceof Fraction[]){
            Fraction t = new Fraction();
            for(int i = 0; i<o.length; i++) {
                t.add((Fraction) o[i]);
            }
            return t;
        } else{
            throw new NullPointerException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction fraction = (Fraction) o;
        return num == fraction.num && denom == fraction.denom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num,denom);
    }


    /*  maxmin  */

    private Fraction searchMax(Fraction f) {
        int a = this.num*f.denom;
        int b = this.denom*f.num;

        if(a>b) {
            //this.adjust();
            return this;
        } else {
            //f.adjust();
            return f;
        }
    }

    public static Fraction max(Fraction[] f) {
        Fraction max = new Fraction();
        max = f[0];

        for(int i=1;i<f.length;i++) {
            max = max.searchMax(f[i]);
        }
        max.print();
        return max;
    }

    private Fraction searchMin(Fraction f) {
        int a = this.num*f.denom;
        int b = this.denom*f.num;

        if(a<b) {
            this.adjust();
            return this;
        } else {
            f.adjust();
            return f;
        }
    }

    public static Fraction min(Fraction[] f) {
        Fraction min = new Fraction();
        min = f[0];

        for(int i=1;i<f.length;i++) {
            min = min.searchMin(f[i]);
        }
        min.print();
        return min;
    }

    private boolean isMoreThen(Fraction f) {
        int a = this.num*f.denom;
        int b = this.denom*f.num;

        if(a>b) {
            return true;

        } else return false;
    }
                    /*     */




                 /* mycompare compare  */


    public int myCompareTo(Object o) {
        if(o instanceof Fraction) {
            int a = this.num*((Fraction)o).denom;
            int b = this.denom*((Fraction) o).num;
            if(a>b) {
                return 1;
            } else if(a==b) {
                return 0;
            } else return -1;
        } else {
            System.out.println("Incompatible type");
            return -100;
        }
    }

    public int compareTo(Fraction f){
        if(f instanceof Fraction) {
            int a = this.num*((Fraction)f).denom;
            int b = this.denom*((Fraction) f).num;
            if(a>b) {
                return 1;
            } else if(a==b) {
                return 0;
            } else return -1;
        } else {
            System.out.println("data type mismatch");
            return -100;
        }
    }

    private static Fraction[] sort(Fraction[] a) {
        Fraction temp;
        Fraction[] f = a;
        for (int i = 0; i < f.length; i++) {
            for (int j = 1; j < (f.length - i); j++) {
                //if (f[j - 1].isMoreThen(f[j])) {
                //if (f[j-1].compareTo(f[j]) == 1){
                if (f[j-1].myCompareTo(f[j]) == 1){
                    temp = f[j - 1];
                    f[j - 1] = f[j];
                    f[j] = temp;
                }
            }
        }
        return f;
    }


                     /*  */


    Fraction(int n, int d) {
        num = n;
        denom = d;
        adjust();
        reduce();
    }

    Fraction(int a) {
        this(a, 1);
    }

    Fraction() {
        this(0, 1);
    }

    Fraction(String f) {
        if(f.indexOf('/') != -1) {
            String nom = f.substring(0,f.indexOf('/'));
            String den = f.substring(f.indexOf('/')+1);
            this.num = Integer.parseInt(nom);
            this.denom = Integer.parseInt(den);
            adjust();
        } else {
            this.num = Integer.parseInt(f);
            this.denom = 1;
            adjust();
        }
    }

    @Override
    public String toString(){
        if (denom == 1) {
            return num+"";
        } else {
            return num+"/"+denom;
        }
    }
}







