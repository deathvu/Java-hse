package Practice.Factorial;

public class FactorialVer1 {
    public static long factorial(long f){
        if (f>20 || f<0) throw new IllegalArgumentException("wrong f");//long cannot accommodate more than 20!
        if (f<=1) return 1;
        else return f*factorial(f-1);//x! = x*(x-1)!
    }

    public static void main(String[] args) {
        System.out.println(factorial(20));

    }
}
