package chapter16_Moderate;

import java.util.ArrayList;
import java.util.List;

public class Q19_PondSize {
    private static final int[][] direction = {{-1, -1},{-1, 0},{-1, 1},
                                    {0, -1},{0, 1},
                                    {1, -1},{1, 0},{1, 1}};

    List<Integer> pondSizes(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0) return res;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    res.add(computeSize(matrix, i, j));
                }
            }
        }

        return res;
    }

    private int computeSize(int[][] matrix, int r, int c){
        if(r<0 || r>=matrix.length || c<0 || c>=matrix[0].length || matrix[r][c]!=0) return 0;

        int cnt = 1;
        matrix[r][c] = -1;

        for(int[] direc: direction){
            cnt += computeSize(matrix, r+direc[0], c+direc[1]);
        }

        return cnt;
    }
}
