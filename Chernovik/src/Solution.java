import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
   public static LinkedList<String> emails = new LinkedList<String>();

    public static String adjust(String s){
       String s1 = "";
       if (s.substring(s.indexOf("@")).equals("gmail.com")){
           s1 = s.substring(0,s.indexOf("@")).replace(".","");
       }
       else if((s1.substring(s1.indexOf("+")).contains("+"))){
               s1 = s1.substring(0,s1.indexOf("+"));
       }
       return s1;
    }

    public static boolean compareEmails(String s, String s1){
       return adjust(s).equalsIgnoreCase(adjust(s1));
    }

    public static LinkedList<LinkedList<String>> createGroups (LinkedList<String> ls){
       LinkedList<LinkedList<String>> listOfGr = new LinkedList<>();
       for (int i = 0; i < ls.size() ; i++) {
            if (compareEmails(ls.get(i),ls.get(i+1))){
                LinkedList<String> gr1 = new LinkedList<>();
                gr1.add(ls.get(i));
                gr1.add(ls.get(i+1));
                listOfGr.add(gr1);
            } else if (i >= 1 && compareEmails(ls.get(i-1),ls.get(i))){
                listOfGr.getLast().add(ls.get(i));
            }
        }
       return listOfGr;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            String s = scanner.next();
            emails.add(s);
        }
        System.out.println(createGroups(emails).size());
        for (int i = 0; i < createGroups(emails).size() ; i++) {
            System.out.println((createGroups(emails).get(i).get(i)));
        }
    }

}
