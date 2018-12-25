package chapter3_StacksAndQueues;

import java.util.Stack;

public class Q5_SortStack {
    void sort(Stack<Integer> stack){
        Stack<Integer> buffer = new Stack<>();
        while(!stack.isEmpty()) buffer.push(stack.pop());
        int tmp;
        while(!buffer.isEmpty()){
            tmp = buffer.pop();
            while(!stack.isEmpty() && stack.peek()>tmp) buffer.push(stack.pop());
            stack.push(tmp);
        }
    }
}
