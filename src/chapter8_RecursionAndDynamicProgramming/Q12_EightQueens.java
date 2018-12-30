package chapter8_RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Q12_EightQueens {
    static final int GRID_SIZE = 8;

    List<int[]> eightQueens(){
        List<int[]> res = new ArrayList<>();
        int[] columns = new int[8];
        placeQueens(0, columns, res);
        return res;
    }

    private void placeQueens(int curRow, int[] columns, List<int[]> res){
        if(curRow==GRID_SIZE){
            res.add(columns.clone());
            return ;
        }
        for(int i=0;i<GRID_SIZE;i++){
            if(checkValid(curRow, i, columns)){
                columns[curRow] = i;
                placeQueens(curRow+1, columns, res);
            }
        }
    }
    private boolean checkValid(int curRow, int curCol, int[] columns){
        for(int r=0;r<curRow;r++){
            int c = columns[r];
            if(c==curCol) return false;

            int colDiff = Math.abs(curCol-c);
            if(colDiff==curRow-r) return false;
        }
        return true;
    }
}
