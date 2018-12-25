package chapter3_StacksAndQueues;

import java.util.Stack;

public class Q2_StackMin extends Stack<Integer> {
    Stack<Integer> mins;

    public Q2_StackMin(){
        mins = new Stack<>();
    }

    public void push(int value){
        if(value<=min()){
            mins.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        int val = super.pop();
        if(val==min()){
            mins.pop();
        }
        return val;
    }

    public int min(){
        if(mins.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return mins.peek();
    }
}
