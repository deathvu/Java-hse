package Lab5.Browser;

import Lab4.Tab;

public class Browser {
    private Tab[] tabs;
    private int currentTabPos;


    public void addTab(){
        int i = tabs.length+1;
        tabs = new Tab[i];
        currentTabPos = tabs.length-1;
    }

    public void addPage(String page, int tabNum){
        currentTabPos = tabNum;
        addPage(page);
    }

    public void addPage(String page){tabs[currentTabPos].addPage(page);}

    public void changeTab(int tabNum){
        if(tabNum < tabs.length && tabNum>=0){
        currentTabPos = tabNum;
        } else {
            System.out.println("Такой вкладки нет!");
        }
    }

    public int numOfTabs(){
        System.out.println(tabs.length);
        return tabs.length;}

    public void printCurrentPage(){tabs[currentTabPos].printCurrentPage();}

    public void pageBack(){tabs[currentTabPos].back();}

    public void pageForward(){tabs[currentTabPos].forward();}

    public void printCurrentTab(){
        System.out.println(currentTabPos);
    }



    Browser() {
        tabs = new Tab[1];
        currentTabPos = 0;
    }
}
