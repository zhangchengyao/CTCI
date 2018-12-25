package chapter3_StacksAndQueues;

import java.util.Stack;

public class Q4_QueueViaStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    Q4_QueueViaStacks(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value){
        if(stack1.isEmpty()){
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(value);
    }

    public int dequeue(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) return Integer.MAX_VALUE;
        return stack2.pop();
    }
}
