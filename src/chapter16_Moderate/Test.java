package chapter16_Moderate;

public class Test {
    public static void main(String[] args){
        Q19_PondSize test = new Q19_PondSize();
        int[][] matrix={{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
        System.out.println(test.pondSizes(matrix));
    }
}
