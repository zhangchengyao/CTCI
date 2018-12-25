package chapter3_StacksAndQueues;

public class Test {
    public static void main(String[] args){
        Q3_StackOfPlates test = new Q3_StackOfPlates(2);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        System.out.println(test.pop());
        System.out.println(test.popAt(0));
        System.out.println(test.pop());
    }
}
