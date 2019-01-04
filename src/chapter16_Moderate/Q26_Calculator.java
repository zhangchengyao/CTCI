package chapter16_Moderate;

import java.util.Stack;

public class Q26_Calculator {
    enum Operator{ ADD, SUBTRACT, MULTIPLY, DIVIDE}

    double calculate(String input){
        Stack<Double> numberStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();
        int cur = 0;
        while(cur<input.length()){
            if(Character.isDigit(input.charAt(cur))){
                int number = parseNextNumber(input, cur);
                numberStack.push((double)number);
                cur += Integer.toString(number).length();
            } else {
                Operator ope = parseNextOperator(input, cur);
                int prior = priority(ope);
                while(!operatorStack.isEmpty()){
                    Operator top = operatorStack.peek();
                    if(prior<=priority(top)){
                        operatorStack.pop();
                        double second = numberStack.pop();
                        double first = numberStack.pop();
                        double res = applyOp(first, second, top);
                        numberStack.push(res);
                    } else {
                        break;
                    }
                }
                operatorStack.push(ope);
                cur++;
            }
        }

        while(!operatorStack.isEmpty()){
            Operator op = operatorStack.pop();
            double second = numberStack.pop();
            double first = numberStack.pop();
            numberStack.push(applyOp(first, second, op));
        }

        return numberStack.pop();
    }

    private double applyOp(double first, double second, Operator op){
        if(op==Operator.ADD) return first + second;
        else if(op==Operator.SUBTRACT) return first - second;
        else if(op==Operator.MULTIPLY) return first * second;
        else return first / second;
    }
    private int parseNextNumber(String input, int offset){
        int cur = offset;
        while(cur<input.length()){
            if(!Character.isDigit(input.charAt(cur))) break;
            cur++;
        }
        return Integer.parseInt(input.substring(offset, cur));
    }

    private Operator parseNextOperator(String input, int offset){
        char c  = input.charAt(offset);
        if(c=='+') return Operator.ADD;
        else if(c=='-') return Operator.SUBTRACT;
        else if(c=='*') return Operator.MULTIPLY;
        else return Operator.DIVIDE;
    }
    private int priority(Operator operator){
        if(operator==Operator.ADD || operator==Operator.SUBTRACT) return 1;
        else return 2;
    }
}
