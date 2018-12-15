package chapter1_ArraysAndStrings;

public class Test {
    public static void main(String[] args){
        int[][] matrix = new int[4][4];
        int t = 1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = t++;
            }
        }

        Q7_RotateMatrix test = new Q7_RotateMatrix();
        test.rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
//        System.out.println(test.compress("aaaabbgdsss"));
    }
}
