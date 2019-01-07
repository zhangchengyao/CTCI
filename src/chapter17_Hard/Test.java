package chapter17_Hard;

import chapter16_Moderate.Q23_Rand7FromRand5;

import java.util.*;

public class Test {
    public static void main(String[] args){
        int[][] matrix = {{0,1,0},{1,1,0},{1,1,0}};
        int[][] res = new Q23_MaxSquareMatrix().findSquare(matrix);
        for(int[] point: res){
            System.out.println(point[0]+" "+point[1]);
        }
    }
}
