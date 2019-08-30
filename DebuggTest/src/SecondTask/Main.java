package SecondTask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Chernov", 7));
        students.add(new Student("Kan", 5));
        students.add(new Student("Sidorov", 8));
        students.add(new Student("Petrov", 9));
        students.add(new Student("Ivanov", 3));
        Comparator<Student> studentComparator = new AverageMarkComparator();
        students.sort(studentComparator);
        for (Student s : students) {
            s.printInfo();
            System.out.println();
        }

        System.out.println("------------------");
        System.out.println();


        TreeSet<Human> treeSet = new TreeSet<>();
        treeSet.add(new Person("Kan Andrey",21321));
        treeSet.add(new Person("Chernov","Programming"));
        treeSet.add(new Person("Svetlana","Math"));
        treeSet.add(new Person("Boris","Programming",123421));
        treeSet.add(new Person("Andrey",32165));
        treeSet.add(new Student("Roman",2132));
        for (Human p : treeSet){
            p.printInfo();
            System.out.println();
        }


    }
}
