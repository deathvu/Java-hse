package Practice.Factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class FactorialVer2 {
    protected static ArrayList<BigInteger> table = new ArrayList<>(); //создание кэша
    static {
        table.add(BigInteger.valueOf(1));
    }
    public static BigInteger factorial(int x){
        if (x<0) throw new IllegalArgumentException("wrong x");
        for (int size = table.size();size<=x;size++){
        BigInteger lastFact = (BigInteger)table.get(size-1);
        BigInteger nextFact = lastFact.multiply(BigInteger.valueOf(size));
        table.add(nextFact);
    }
    return (BigInteger)table.get(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (; ; ) {
            System.out.print("Enter value -> ");
            String line = in.readLine();
            if (line == null || line.equals("exit")) break;
            try {
                int x = Integer.parseInt(line);
                System.out.println("Factorial is " + FactorialVer2.factorial(x));
            }
            catch (Exception e){
                System.out.println("Invalid input");
            }
        }

    }
}

