package Lab5.VersionsOfStack;

import Lab5.Fraction.Fraction;

public class StackOfFractions {
    private Fraction[] st;
    private int tos = -1;

    StackOfFractions(Fraction[] f) {
        this.st = f;
    }

    public Fraction pop() {
        Fraction out = st[tos];
        tos--;
        return out;
    }

    public void push(Fraction item) {
        if (tos == st.length - 1) {
            extension();
            st[++tos] = item;
        } else {
            st[++tos] = item;
        }
    }

    private void extension() {
        Fraction[] helper = new Fraction[st.length * 2];
        for (int i = 0; i < st.length; i++) {
            helper[i] = st[i];
        }
        st = helper;
    }

    public Fraction peek(){
        return st[tos];
    }

    public int size() {
        return tos+1;
    }
}
