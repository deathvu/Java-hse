package Lab5.Exer12;

import Lab5.Interfaces.MyComparable;

public class Student implements MyComparable {

    private String name;
    private int mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }



    @Override
    public int myCompareTo(Object a) {
        if(a instanceof Student){
            if(this.mark < ((Student)a).mark) {
                return -1;
            } else if(this.mark == ((Student)a).mark) {
                return 0;
            } else return 1;
        } else {
            System.out.println("data type mismatch");
            return -123;
        }

    }


    @Override
    public String toString(){
        return "Name : "+name+", mark : "+mark;
    }


    public static void sort(Student[] a){
        Student tmp;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j].myCompareTo(a[j+1]) < 0) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }


    Student(String name, int mark){
        this.name = name;
        this.mark = mark;
    }
}


