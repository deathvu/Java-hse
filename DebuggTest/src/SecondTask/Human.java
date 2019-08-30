package SecondTask;

public class Human {
    String name;

    Human(String name){
        this.name =name;
    }

    Human(){
        this("Ivanov ivan");
    }

    public void printInfo(){
        System.out.println("Name : "+ name +" ;");
    }

    public String getName(){
        return name;
    }

}
