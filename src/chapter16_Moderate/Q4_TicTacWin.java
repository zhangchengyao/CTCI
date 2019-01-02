package chapter16_Moderate;

import java.util.ArrayList;
import java.util.List;

public class Q4_TicTacWin {
    class Check{
        int row, col;
        private int rowInc, colInc;

        Check(int _row, int _col, int _rowInc, int _colInc){
            row = _row;
            col = _col;
            rowInc = _rowInc;
            colInc = _colInc;
        }

        void increment(){
            row += rowInc;
            col += colInc;
        }
        boolean inBounds(int size){
            return row>=0 && row<size && col>=0 && col<size;
        }
    }

    /* 0-no winner, 1-player1, 2-player2 */
    int hasWon(int[][] board){
        if(board==null || board.length==0 || board.length!=board[0].length) return -1;

        int size = board.length;

        List<Check> instructions = new ArrayList<>();
        for(int i=0;i<size;i++){
            instructions.add(new Check(i, 0, 0, 1));
            instructions.add(new Check(0, i, 1, 0));
        }
        instructions.add(new Check(0, 0, 1, 1));
        instructions.add(new Check(0, size-1, 1, -1));

        for(Check check: instructions){
            int first = board[check.row][check.col];
            if(first==0) continue;
            while(check.inBounds(size)){
                check.increment();
                if(board[check.row][check.col]!=first) break;
            }
            if(!check.inBounds(size)) return first;
        }

        return 0;
    }

}
