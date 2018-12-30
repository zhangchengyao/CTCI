package chapter8_RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {
    public static void main(String[] args){
        Q14_BooleanEvaluation test = new Q14_BooleanEvaluation();
        System.out.println(test.countEval("0&0&0&1^1|0", true));
    }
}
