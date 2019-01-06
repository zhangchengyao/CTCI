package chapter17_Hard;

import java.util.*;

public class Test {
    public static void main(String[] args){
        Q20_ContinuousMedian test = new Q20_ContinuousMedian();
        test.insert(1);
        System.out.println(test.getMedian());
        test.insert(3);
        System.out.println(test.getMedian());
        test.insert(8);
        System.out.println(test.getMedian());
        test.insert(5);
        System.out.println(test.getMedian());
    }
}
