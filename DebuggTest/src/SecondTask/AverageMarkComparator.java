package SecondTask;

import java.util.Comparator;

class AverageMarkComparator implements Comparator<Student> {

   public int compare (Student a,Student b){
       if(a.getAverageMark()> b.getAverageMark())
           return -1;
       else if(a.getAverageMark()< b.getAverageMark())
           return 1;
       else
           return 0;
   }
}

