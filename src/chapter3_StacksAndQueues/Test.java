package chapter3_StacksAndQueues;

public class Test {
    public static void main(String[] args){
        Q4_QueueViaStacks test = new Q4_QueueViaStacks();
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        System.out.println(test.dequeue());
        test.enqueue(4);
        System.out.println(test.dequeue());
    }
}
