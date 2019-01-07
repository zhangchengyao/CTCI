package chapter17_Hard;

public class Q23_MaxSquareMatrix {
    // top left corner and bottom right corner
    // 0 -- white, 1 -- black
    int[][] findSquare(int[][] matrix){
        Cell[][] mat = preprocess(matrix);

        for(int len=matrix.length;len>1;len--){
            for(int r=0;r<=matrix.length-len;r++){
                for(int c=0;c<matrix.length-len;c++){
                    if(isValid(mat, r, c, len)){
                        int[][] res = new int[2][2];
                        res[0][0] = r;
                        res[0][1] = c;
                        res[1][0] = r+len-1;
                        res[1][1] = c+len-1;
                        return res;
                    }
                }
            }
        }

        return null;
    }

    private boolean isValid(Cell[][] mat, int r, int c, int len){
        Cell topLeft = mat[r][c];
        Cell topRight = mat[r][c+len-1];
        Cell bottomLeft = mat[r+len-1][c];
        Cell bottomRight = mat[r+len-1][c+len-1];

        int top = topLeft.blackRight-topRight.blackRight;
        int bottom = bottomLeft.blackRight-bottomRight.blackRight;
        int left = topLeft.blackBelow-bottomLeft.blackBelow;
        int right = topRight.blackBelow-bottomRight.blackBelow;
        if(topRight.val==1) top++;
        if(bottomRight.val==1){
            bottom++;
            right++;
        }
        if(bottomLeft.val==1) left++;

        return top>=len && bottom>=len && left>=len && right>=len;
    }

    private Cell[][] preprocess(int[][] matrix){
        Cell[][] mat = new Cell[matrix.length][matrix.length];
        for(int c=matrix.length-1;c>=0;c--){
            for(int r=matrix.length-1;r>=0;r--){
                if(matrix[r][c]==1){
                    mat[r][c] = new Cell(matrix[r][c],
                                        1+(c<matrix.length-1?mat[r][c+1].blackRight:0),
                                        1+(r<matrix.length-1?mat[r+1][c].blackBelow:0));
                } else {
                    mat[r][c] = new Cell(matrix[r][c],
                                        c<matrix.length-1?mat[r][c+1].blackRight:0,
                                        r<matrix.length-1?mat[r+1][c].blackBelow:0);
                }
            }
        }
        return mat;
    }

    class Cell{
        int val;
        int blackRight;
        int blackBelow;

        Cell(int v, int r, int b){
            val = v;
            blackRight = r;
            blackBelow = b;
        }
    }
}
