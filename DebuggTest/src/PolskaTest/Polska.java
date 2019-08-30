package PolskaTest;

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
    private static void execution(LinkedList<Integer> st, char op) {
        int r = st.removeLast();
        int l = st.removeLast();

        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case ':':
                if (r!=0){
                st.add(l / r);
                }  else {
                    throw new NullPointerException("No Null!");
                    }
                break;
        }
    }
    public static int evaluation(String s) {
        LinkedList<Integer> statements = new LinkedList<Integer>();
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
                    operators.removeLast(); /* если попадается ), то берем все элементы с конца и используем метод выполнить
                                             до тех пор, пока последним элементом не станет ( */
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && priority(operators.getLast()) >= priority(c))
                    execution(statements, operators.removeLast());
                    operators.add(c);   /*если чар явлся оператором, то метод 'выполнить' до тех пор,
                                        пока не закончатся операторы и приоритет последнего будет выше приоритета
                                         на вход из листа операторов, добавлять в лист операторов */
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                statements.add(Integer.parseInt(operand));
            }
        }
        while (!operators.isEmpty())
            execution(statements, operators.removeLast());
        return statements.get(0);  // возврат результата
    }

    public static void main(String[] args) {
        System.out.println((int)'-');
    }

}
