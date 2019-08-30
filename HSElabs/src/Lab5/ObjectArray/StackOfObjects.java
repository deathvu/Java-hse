package Lab5.ObjectArray;

public class StackOfObjects extends ObjectArray {

    public int size() {
        return end+1;
    }

    public void clear() {
        objCapacity = new Object[5];
    }

    public Object peek() {
        return objCapacity[end];
    }

    public boolean empty() {
        if(end == -1) {
            return true;
        } else return false;
    }

    public Object showElement(int a) {
        if(end>=a) {
            return objCapacity[a];
        } else return 0;
    }

    public void push(int item) {
        if(end+1 < objCapacity.length) {
            end++;
            objCapacity[end] = item;

        } else {
            extension();
            end++;
            objCapacity[end] = item;
        }
    }

    public Object pop() {
        if(end> - 1 ){
            Object poppedItem = objCapacity[end];
            end--;
            return poppedItem;
        } else {
            return -1;
        }
    }


    StackOfObjects(int length) {
        super(length);
    }
    StackOfObjects() {
        this(2);
    }
    }

