package chapter3_StacksAndQueues;

import java.util.Stack;

public class Test {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);stack.push(2);stack.push(9);stack.push(10);stack.push(4);
        Q5_SortStack test = new Q5_SortStack();
        test.sort(stack);
        while(!stack.isEmpty()) System.out.println(stack.pop());
    }
}
