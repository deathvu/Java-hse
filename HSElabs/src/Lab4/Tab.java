package Lab4;

public class Tab {
    private String currentPage;
    NDStack capacityMain;
    NDStack capacitySecond;


    public void addPage(String page) {
        currentPage = page;
        capacityMain.push(page);
        NDStack capacitySecond = new NDStack();
    }

    public void back() {
        if (capacityMain.size() < 1) {
            System.out.println("Error,no back");
        } else {
            capacitySecond.push(capacityMain.pop());
            currentPage = capacityMain.peek();
            System.out.println(capacitySecond.peek());
        }
    }

    public void forward() {
        if (capacitySecond.size() == 0) {
            System.out.println("Error,no forward");
        } else {
            capacityMain.push(capacitySecond.pop());
            currentPage = capacityMain.peek();
        }
    }

    public void printCurrentPage() {
        System.out.println("Current page :" + currentPage);
    }



    Tab(String startPage) {
        capacityMain = new NDStack();
        capacitySecond = new NDStack();
        currentPage = startPage;
        addPage(startPage);
    }

    Tab(){
        this("yandex.ru");
        //addPage("yandex.ru");
    }
}

