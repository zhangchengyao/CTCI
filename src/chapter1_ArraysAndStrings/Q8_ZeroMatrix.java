package chapter1_ArraysAndStrings;

public class Q8_ZeroMatrix {
    void setZeros(int[][] matrix){
        if(matrix==null || matrix.length==0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowHasZero = false;
        boolean colHasZero = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(i==0) rowHasZero = true;
                    if(j==0) colHasZero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // scan the first row
        for(int i=1;i<n;i++){
            if(matrix[0][i]==0){
                for(int j=1;j<m;j++){
                    matrix[j][i] = 0;
                }
            }
        }
        // scan the first column
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<n;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowHasZero){
            for(int i=0;i<n;i++){
                matrix[0][i] = 0;
            }
        }
        if(colHasZero){
            for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
    }
}
