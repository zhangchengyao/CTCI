package chapter1_ArraysAndStrings;

public class Q7_RotateMatrix {
    void rotate(int[][] matrix){
        if(matrix==null || matrix.length==0) return ;
        int n = matrix.length;
        int start = 0;
        while(n>0){
            int end = start+n-1;
            for(int i=start;i<end;i++){
                int offset = i-start;

                int tmp = matrix[start][i];

                // left -> top
                matrix[start][i] = matrix[end-offset][start];
                // bottom -> left
                matrix[end-offset][start] = matrix[end][end-offset];
                // right -> bottom
                matrix[end][end-offset] = matrix[i][end];
                // top -> right
                matrix[i][end] = tmp;
            }
            start++;
            n -= 2;
        }
    }
}
