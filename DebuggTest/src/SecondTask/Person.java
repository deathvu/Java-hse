package SecondTask;

public class Person extends Human implements Comparable<Person>  {
    int averageMark;
    String specification;

    Person(String name, String specification){
        super(name);
        this.specification = specification;
    }

    Person(String name, int averageMark){
        super(name);
        this.averageMark = averageMark;
    }

    Person(String name,String specification, int averageMark){
        super(name);
        this.specification = specification;
        this.averageMark = averageMark;
    }

    @Override
    public void printInfo(){
        if (specification!=null&&averageMark!=0) {
            System.out.println("Teacher with specification: " + specification + ", and student with mark: " + averageMark + ", ");
        }else if (specification!=null&&averageMark==0){
            System.out.println("Teacher with specification : "+specification+", ");
        }
        else {
            System.out.println("Student with mark : "+averageMark+", ");
        }
        super.printInfo();
    }

    @Override
    public int compareTo(Person p){
        return name.compareTo(p.getName());
    }

    public int getAverageMark(){
        return averageMark;
    }

    public String getSpecification(){
        return specification;
    }


}
