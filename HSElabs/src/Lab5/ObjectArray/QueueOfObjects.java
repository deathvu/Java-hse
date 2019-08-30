package Lab5.ObjectArray;


public class QueueOfObjects extends ObjectArray {
    private int begin;


    public void push(int item){
        adjust();
        super.push(item);
    }

    public Object get() {
        clear();
        if(end == -1) {
            return null;
        } else {
            return objCapacity[++begin];
        }

    }


    private void adjust(){
        if(end +1 == objCapacity.length) {
            if(begin >-1) {
                shift();
            } else {
                extension();
            }
        }
    }

    private void shift(){
        Object[] tmp = new Object[objCapacity.length];
        for(int i = 0;i<end-begin; i++){
            tmp[i] = objCapacity[begin+1+i];
        }
        objCapacity = tmp;
    }

    private void clear(){
        if(begin == end){
            end = -1;
            begin = -1;
        }
    }



    QueueOfObjects(int size) {
        super(size);
        begin = -1;

    }
    QueueOfObjects(){
        this(1);
    }

}
