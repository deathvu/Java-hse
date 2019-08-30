package Lab5.Exer12;

public class MainSt {
    public static void main(String[] args) {
        Student[] arr = new Student[5];
        arr[0] = new Student("Andrey",4);
        arr[1] = new Student("Eandrey",3);
        arr[2] = new Student("Dandrey",1);
        arr[3] = new Student("Candrey",2);
        arr[4] = new Student("Bandrey",0);

        Student.sort(arr);

        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i].toString());
        }

    }
}
