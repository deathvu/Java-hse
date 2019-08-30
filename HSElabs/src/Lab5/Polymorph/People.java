package Lab5.Polymorph;
import java.util.Random;

public class People {
    public People(){
    }
    public void print(){
        System.out.println("People");
    }

    public static void main(String[] args) {
        People a[] = new People[2];
        a[0]= new Student();
        a[1]=new Teacher();
        Random r = new Random();
        a[r.nextInt(2)].print();

    }
}

