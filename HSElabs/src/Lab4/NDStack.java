package Lab4;

public class NDStack {
    private String[] st;
    private int tos = -1;


    public String pop() {
        String out = st[tos];
        tos--;
        return out;
    }

    public void push(String item) {
        if (tos == st.length - 1) {
            extension();
            st[++tos] = item;
        } else {
            st[++tos] = item;
        }
    }

    private void extension() {
        String[] helper = new String[st.length * 2];
        for (int i = 0; i < st.length; i++) {
            helper[i] = st[i];
        }
        st = helper;
    }

    public String peek(){
        return st[tos];
    }

    public int size() {
        return tos+1;
    }




    NDStack(int length) {
        this.st = new String[length];
    }

    NDStack() {
        this.st = new String[1];
    }

    @Override
    public String toString() {
        String stack ="[";

        for (int i = 0; i <tos+1; i++) {
            if(i<tos){
                stack=stack+st[i]+", ";
            } else {
                stack=stack+st[i];
            }
        }
        stack=stack+"]";
        return stack;
    }

    public static void main(String[] args) {
        NDStack x = new NDStack();
        x.push("dsadsa");
        x.push("dsa");
        x.push("dsadsadsadsa12");
        System.out.println(x.toString());
    }
}
