package chapter8_RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {
    public static void main(String[] args){
        int[] a = {1,2,3};
        int[] b = a.clone();
        b[1] = 111;
        System.out.println(a[1]);
    }
}
