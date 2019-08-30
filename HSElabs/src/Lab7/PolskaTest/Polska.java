package Lab7.PolskaTest;

import Lab5.Fraction.Fraction;

import java.util.LinkedList;

public class Polska {

    private static boolean isSplit(char c) {
        return c == ' ';
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == ':';
    }

    private static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case ':':
                return 2;
            default:
                return -1;
        }
    }

    private static void execution(LinkedList<Fraction> st, char op) {
        Fraction r = st.removeLast();
        Fraction l = st.removeLast();

        switch (op) {
            case '+':
                st.add(l.add(r));
                break;
            case '-':
                st.add(l.sub(r));
                break;
            case '*':
                st.add(l.mult(r));
                break;
            case ':':
                if (!r.equals(0)){
                st.add(l.div(r));
                }  else {
                    throw new NullPointerException("No Null!");
                    }
                break;
        }
    }

    public static Fraction evaluation(String s) {
        LinkedList<Fraction> statements = new LinkedList<Fraction>();
        LinkedList<Character> operators = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isSplit(c))
                continue;
            if (c == '(')
                operators.add('('); // если попадается (, добавляем в лист скобку и идем дальше
            else if (c == ')') {
                while (operators.getLast() != '(')
                    execution(statements,operators.removeLast());
                    operators.removeLast();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && priority(operators.getLast()) >= priority(c))
                    execution(statements, operators.removeLast());
                    operators.add(c);
            } else {
                String s1 = s;
                Fraction[] fr = listFr(s1);
                if (fr.length > 0 && statements.size() != fr.length) {
                    for (int j = 0; j < fr.length; j++) {
                        statements.add(fr[j]);
                    }
                }
            }
        }
        while (!operators.isEmpty())
            execution(statements, operators.removeLast());
        return statements.getFirst();  // возврат результата
    }

    public static String editStr(String s){
                String s1 = "";
                s1 = s.replaceAll("[-:*+]"," ");
                s1 = s1.replaceAll("[()]","");
                return s1;
            }
            public static Fraction[] listFr(String s){
                String[] str = editStr(s).split(" ");
                Fraction[] fr = new Fraction[str.length];
                for (int i = 0; i < str.length ; i++) {
                    fr[i]=new Fraction(str[i]);
        }
        return fr;
    }


    public static void main(String[] args) {
        String s = "(1/2+1/3)*1/2";
        evaluation(s).print();
    }
}


