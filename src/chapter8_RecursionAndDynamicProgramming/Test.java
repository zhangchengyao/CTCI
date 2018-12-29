package chapter8_RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<Integer> set = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> res = new Q4_PowerSet().powerSet2(set);
        for(List<Integer> subset: res){
            for(int elem: subset){
                System.out.print(elem+" ");
            }
            System.out.println();
        }
    }
}
