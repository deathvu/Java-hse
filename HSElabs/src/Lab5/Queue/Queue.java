package Lab5.Queue;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Arrays;

public class Queue {
        private int[] queue;
        private int end;
        private int begin;


        public void put(int elem) {
            adjust();
            System.out.print("put : [ ");
            queue[++end] = elem;
            for (int i = 0; i < queue.length; i++) {
                System.out.print(queue[i]+"  ");
            }
            System.out.print("]");
            System.out.println();
        }

        public int get() {
        //System.out.println("get");
        clear();
        if (end == -1) {
            //throw new NullPointerException();
            return -100000;
        } else {
            return queue[++begin];
        }

    }


        private void adjust(){
            if (end==queue.length-1) {
               if (begin>-1){
                   //System.out.println("do hift");
                   shift();
               }
               else{
                   //System.out.println("ext");
                   extension();
               }
            }
        }

        private void shift(){
            int t[] = new int[queue.length];
            /*for (int i = 0; i < t.length; i++) {
                System.out.print(" t["+i+"] = " + t[i]);
            }*/
            System.out.println();
            int moves = begin+1;
            for (int i=0;i<end-begin;i++){
                t[i]=queue[i+begin+1];
            }
            /*for (int i = 0; i < t.length; i++) {
                System.out.print(" t["+i+"] = " + t[i]);
            }*/
            System.out.println();
            end=end-moves;
            begin = begin-moves;
            System.out.println("Position of end: " + end + ", Position of begin: " + begin);
            queue = t;
        }

        private void extension(){
            queue=Arrays.copyOf(queue,queue.length*2);
        }


        private boolean isEmpty() {
            return (end == begin);
        }

        private void clear(){
            if(isEmpty()){
                begin=-1;
                end=-1;
            }
        }


        Queue() {
            this(1);
        }

        Queue(int size){
            queue = new int[size];
            end = -1;
            begin = -1;
        }

}



