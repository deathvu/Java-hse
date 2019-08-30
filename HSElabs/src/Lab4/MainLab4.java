package Lab4;
import java.util.Scanner;

public class MainLab4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter:");
        String adding = scan.next();
        Tab t = new Tab("mail.ru");

        while (adding != "stop") {
            if (adding.equals("back")) {
                t.back();
                t.printCurrentPage();
                adding = scan.next();
            } else if (adding.equals("forward")) {
                t.forward();
                t.printCurrentPage();
                adding = scan.next();
            }
        }
    }

    }








