package chapter16_Moderate;

import java.util.HashSet;

public class Q22_LangtonAnt {
    class Position{
        int row;
        int col;

        Position(int _row, int _col){
            row = _row;
            col = _col;
        }

        public boolean equals(Object o){
            if(o instanceof Position){
                Position p = (Position) o;
                return row==p.row && col==p.col;
            } else {
                return false;
            }
        }

        public int hashCode(){
            return (row*31) ^ col;
        }
    }

    enum Orientation{
        right, left, up, down;

        Orientation getTurn(boolean clockwise){
            if(this==right){
                return clockwise?down:up;
            } else if(this==left){
                return clockwise?up:down;
            } else if(this==up){
                return clockwise?right:left;
            } else {
                return clockwise?left:right;
            }
        }
    }

    class Ant{
        Position position;
        Orientation orientation;

        void turn(boolean clockwise){
            orientation = orientation.getTurn(clockwise);
        }

        void move(){
            if(orientation==Orientation.left){
                position.col--;
            } else if(orientation==Orientation.right){
                position.col++;
            } else if(orientation==Orientation.up){
                position.row--;
            } else {
                position.row++;
            }
        }
    }

    class Grid{
        private HashSet<Position> whiteGrids;
        private Ant ant;
        private Position topLeft;
        private Position bottomRight;

        Grid(){
            whiteGrids = new HashSet<>();
            ant = new Ant();
            topLeft = new Position(0,0);
            bottomRight = new Position(0,0);
        }

        void move(){
            Position pos = ant.position;
            if(whiteGrids.contains(pos)){
                ant.turn(true);
            } else {
                ant.turn(false);
            }
            flip();
            ant.move();
            update(ant.position);
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int i=topLeft.row;i<=bottomRight.row;i++){
                for(int j=topLeft.col;j<=bottomRight.col;j++){
                    if(i==ant.position.row && j==ant.position.col){
                        sb.append(ant.orientation).append(" ");
                    } else if(isWhite(i, j)){
                        sb.append("W ");
                    } else {
                        sb.append("B ");
                    }
                }
                sb.append('\n');
            }
            return sb.toString();
        }

        boolean isWhite(int r, int c){
            Position p = new Position(r, c);
            return whiteGrids.contains(p);
        }

        private void flip(){
            Position pos = ant.position;
            if(whiteGrids.contains(pos)){
                whiteGrids.remove(pos);
            } else {
                whiteGrids.add(pos);
            }
        }

        private void update(Position pos){
            int r = pos.row;
            int c = pos.col;
            topLeft.row = Math.min(topLeft.row, r);
            topLeft.col = Math.min(topLeft.col, c);
            bottomRight.row = Math.max(bottomRight.row, r);
            bottomRight.col = Math.max(bottomRight.col, c);
        }
    }

    void printkMoves(int K){
        Grid grid = new Grid();
        for(int i=0;i<K;i++){
            grid.move();
        }
        System.out.println(grid.toString());
    }
}
