package Lab3;
import java.util.Stack;
import java.util.EmptyStackException;

class TabStandStack {
    int p = -1;
    int currentPage;
    Stack<Integer> capacityMain = new Stack<>();
    Stack<Integer> capacitySecond = new Stack<>();

    public void printCurrentPage() {
        System.out.println("Current page :" + currentPage);

    }

    TabStandStack(int page) {
        currentPage = page;
        addPage(page);
    }

    TabStandStack() {
        currentPage = 1;
        addPage(1);
    }

    void addPage(int page) {
        currentPage = page;
        capacityMain.push(page);
        capacitySecond.clear();
    }

    void back() {
        if (capacityMain.size() == 1) {
            System.out.println("Error,no back");
        } else {
            capacitySecond.push(capacityMain.pop());
            currentPage = capacityMain.peek();
            System.out.println(capacitySecond.peek());
        }
    }

    void forward() {
        if (capacitySecond.empty()) {
            System.out.println("Error,no forward");
        } else {
            capacityMain.push(capacitySecond.pop());
            currentPage = capacityMain.peek();
        }

    }
}