package Hashcode.Hcode;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        Collection<Fraction> arrayList = new ArrayList<>();
        arrayList.add(new Fraction(1,2));
        arrayList.add(new Fraction(1,3));
        arrayList.add(new Fraction(2,9));
        arrayList.add(new Fraction(6,11));
        Fraction finder = new Fraction(0);
        int i = 0;
        for (Fraction e: arrayList){
            if (finder.hashCode() == e.hashCode()){
                System.out.println("Дробь в листе");
                i = 1;
                break;
            }
        }
        if (i == 0){
            System.out.println("Дроби в списке нет");
        }


    }

    public void searchFr(Fraction f){
        if (this.equals(f) == true){
            System.out.println("Дробь есть в списке!");
        }else {
            System.out.println("Дроби нет");
        }
    }
}
