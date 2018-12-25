package chapter3_StacksAndQueues;

import java.util.ArrayList;

public class Q3_StackOfPlates {
    private ArrayList<Stack> stacks;
    private int capacity;

    public Q3_StackOfPlates(int _capacity){
        stacks = new ArrayList<>();
        capacity = _capacity;
    }

    public void push(int value){
        Stack lastStack = stacks.size()==0?null:stacks.get(stacks.size()-1);
        if(lastStack!=null && !lastStack.isFull()) lastStack.push(value);
        else{
            Stack stack = new Stack(capacity);
            stack.push(value);
            stacks.add(stack);
        }
    }

    public int pop(){
        Stack lastStack = stacks.size()==0?null:stacks.get(stacks.size()-1);
        if(lastStack==null || lastStack.isEmpty()) return Integer.MAX_VALUE;
        int res = lastStack.pop();
        if(lastStack.isEmpty()) stacks.remove(lastStack);
        return res;
    }

    public int popAt(int index){
        int res = stacks.get(index).pop();
        for(int i=index;i<stacks.size()-1;i++){
            stacks.get(i).push(stacks.get(i+1).removeBottom());
        }
        if(stacks.get(stacks.size()-1).isEmpty()) stacks.remove(stacks.size()-1);
        return res;
    }
    class Stack{
        private int capacity;
        private ArrayList<Integer> data;

        public Stack(int _capacity){
            capacity = _capacity;
            data = new ArrayList<>();
        }

        public boolean isFull(){
            return data.size() == capacity;
        }

        public boolean isEmpty(){
            return data.size() == 0;
        }

        public boolean push(int value){
            if(data.size()>=capacity) return false;
            data.add(value);
            return true;
        }

        public int pop(){
            if(data.isEmpty()) return Integer.MAX_VALUE;
            return data.remove(data.size()-1);
        }

        public int removeBottom(){
            return data.remove(0);
        }
    }
}
