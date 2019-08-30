package Lab3;
import java.util.Scanner;

public class MainLab3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the page:");
        int numP = scan.nextInt();
        TabStandStack t = new TabStandStack(1);

        while (numP != 0) {
            if (numP > 0) {
                t.addPage(numP);
                t.printCurrentPage();
                numP = scan.nextInt();
            } else if (numP == -1) {
                t.forward();
                t.printCurrentPage();
                numP = scan.nextInt();
            } else if (numP == -2) {
                t.back();
                t.printCurrentPage();
                numP = scan.nextInt();
            }

        }

    }
}




