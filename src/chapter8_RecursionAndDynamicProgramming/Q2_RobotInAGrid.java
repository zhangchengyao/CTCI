package chapter8_RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q2_RobotInAGrid {
    class Point{
        int row;
        int col;

        Point(int _row, int _col){
            row = _row;
            col = _col;
        }

        public int hashCode(){
            return new Integer(row).hashCode()+new Integer(col).hashCode();
        }

        public boolean equals(Object p){
            if(!(p instanceof Point)) return false;
            return this.row==((Point)p).row && this.col==((Point)p).col;
        }
    }

    List<Point> findPath(boolean[][] maze){
        List<Point> path = new ArrayList<>();

        if(maze==null || maze.length==0) return path;

        if(findPath(maze, maze.length-1, maze[0].length-1, path, new HashSet<>())){
            return path;
        } else {
            return null;
        }
    }

    private boolean findPath(boolean[][] maze, int r, int c, List<Point> path, HashSet<Point> failed){
        if(r<0 || c<0 || !maze[r][c]) return false;

        Point p = new Point(r, c);

        if(failed.contains(p)) return false;

        if((r==0 && c==0) || findPath(maze, r-1, c, path, failed) || findPath(maze, r, c-1, path, failed)){
            path.add(p);
            return true;
        } else {
            failed.add(p);
            return false;
        }
    }
}
