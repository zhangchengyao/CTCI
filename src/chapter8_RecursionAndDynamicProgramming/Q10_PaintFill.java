package chapter8_RecursionAndDynamicProgramming;

public class Q10_PaintFill {
    void paintFill(int[][] screen, int r, int c, int newColor){
        if(screen==null || screen[0].length==0) return ;
        if(r<0 || r>=screen.length || c<0 || c>=screen[0].length) return ;

        int originColor = screen[r][c];
        if(originColor==newColor) return;

        helper(screen, r, c, newColor, originColor);
    }

    private void helper(int[][] screen, int r, int c, int newColor, int originColor){
        if(r<0 || r>=screen.length || c<0 || c>=screen[0].length || screen[r][c]!=originColor) return ;

        screen[r][c] = newColor;

        helper(screen, r-1, c, newColor, originColor);
        helper(screen, r+1, c, newColor, originColor);
        helper(screen, r, c-1, newColor, originColor);
        helper(screen, r, c+1, newColor, originColor);
    }
}
