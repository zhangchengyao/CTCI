package chapter1_ArraysAndStrings;

import java.util.Random;

public class Test {
    public static void main(String[] args){
        int[][] matrix = new int[4][4];
        Random r = new Random();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = r.nextInt(8);
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        Q8_ZeroMatrix test = new Q8_ZeroMatrix();
        test.setZeros(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
//        System.out.println(test.compress("aaaabbgdsss"));
    }
}
