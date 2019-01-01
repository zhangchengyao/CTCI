package chapter10_SortingAndSearching;

public class Test {
    public static void main(String[] args){
        int[][] matrix = {
                {15,20,70,85},
                {20,35,80,96},
                {30,55,95,105}
        };
        int[] res = new Q9_SortedMatrixSearch().search(matrix, 105);
        System.out.print(res[0]+" "+res[1]);
    }
}
