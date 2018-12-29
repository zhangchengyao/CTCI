package chapter8_RecursionAndDynamicProgramming;

public class Test {
    public static void main(String[] args){
        Q1_TripleStep test = new Q1_TripleStep();
        long start = System.currentTimeMillis();
        System.out.println(test.waysOfHops(33));
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start);
        System.out.println(test.countWays(33));
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start);
    }
}
