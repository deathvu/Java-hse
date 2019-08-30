package Lab5.VectorQueue;

import java.util.Vector;

public class VectorQueue {
    private Vector queue;

    VectorQueue(int a){
        this.queue = new Vector(a);
    }

    public void put(int ob){
        queue.add(ob);
    }


    public void get(){
        queue.removeElementAt(0);
    }



    public void print(){
        System.out.println(queue.toString());
    }

    public static void main(String[] args) {
        VectorQueue a = new VectorQueue(5);
        a.put(0);
        a.put(1);
        a.put(2);
        a.put(3);
        a.put(4);
        a.put(5);
        a.get();
        a.get();
        a.print();
    }

    }




