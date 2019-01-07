package chapter17_Hard;

import chapter16_Moderate.Q23_Rand7FromRand5;

import java.util.*;

public class Test {
    public static void main(String[] args){
        int[][] matrix = {{9,-8,1,3,-2},{-3,7,6,-2,4},{6,-4,-4,8,-7}};
        int[][] res = new Q24_MaxSubmatrix().maxSum2D(matrix);
        for(int[] point: res){
            System.out.println(point[0]+" "+point[1]);
        }
    }
}
