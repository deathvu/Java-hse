package Lab5.ObjectArray;

import java.util.Arrays;

public class ObjectArray {
    protected Object[] objCapacity;
    protected int end;


    private Object[] getObjCapacity(){
        return objCapacity;
    }
    private int getEnd(){
        return end;
    }


    public void push(Object item){
        objCapacity[++end] = item;
    }

    protected void extension() { objCapacity= Arrays.copyOf(objCapacity,objCapacity.length+1);}


    ObjectArray(int size) {
        objCapacity = new Object[size];
        end = -1;
    }
    ObjectArray(){
        this(1);
    }

}
