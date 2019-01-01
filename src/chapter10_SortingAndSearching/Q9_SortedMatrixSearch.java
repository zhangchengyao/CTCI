package chapter10_SortingAndSearching;

public class Q9_SortedMatrixSearch {
    class Coordinate{
        int row;
        int col;
        Coordinate(int _row, int _col){
            row = _row;
            col = _col;
        }

        boolean isBefore(Coordinate coord){
            return this.row<=coord.row && this.col<=coord.col;
        }
    }

    int[] search(int[][] matrix, int val){
        Coordinate res = findElement(matrix, new Coordinate(0, 0), new Coordinate(matrix.length-1, matrix[0].length-1), val);
        return res==null?null:new int[]{res.row, res.col};
    }

    private Coordinate findElement(int[][] matrix, Coordinate from, Coordinate to, int x){
        if(!from.isBefore(to)) return null;

        Coordinate upperLeft = new Coordinate(from.row, from.col);
        int diagDist = Math.min(to.row-from.row, to.col-from.col);
        Coordinate lowerRight = new Coordinate(from.row+diagDist, from.col+diagDist);

        while(upperLeft.isBefore(lowerRight)){
            int midR = upperLeft.row + (lowerRight.row-upperLeft.row)/2;
            int midC = upperLeft.col + (lowerRight.col-upperLeft.col)/2;
            if(matrix[midR][midC]==x) return new Coordinate(midR, midC);
            else if(matrix[midR][midC]>x){
                lowerRight.row = midR-1;
                lowerRight.col = midC-1;
            } else {
                upperLeft.row = midR+1;
                upperLeft.col = midC+1;
            }
        }

        Coordinate lowerLeftFrom = new Coordinate(upperLeft.row, from.col);
        Coordinate lowerLeftTo = new Coordinate(to.row, upperLeft.col-1);
        Coordinate res = findElement(matrix, lowerLeftFrom, lowerLeftTo, x);
        if(res!=null) return res;
        else{
            Coordinate upperRightFrom = new Coordinate(from.row, upperLeft.col);
            Coordinate upperRightTo = new Coordinate(upperLeft.row-1, to.col);
            return findElement(matrix, upperRightFrom, upperRightTo, x);
        }
    }


    int[] searchNaive(int[][] matrix, int val){
        if(matrix==null || matrix.length==0) return null;

        int r = 0;
        int c = matrix[0].length-1;
        while(r<matrix.length && c>=0){
            if(matrix[r][c]==val) return new int[]{r, c};
            else if(matrix[r][c]<val) r++;
            else c--;
        }
        return null;
    }
}
