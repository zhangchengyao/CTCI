package chapter10_SortingAndSearching;

public class Test {
    public static void main(String[] args){
        int[] A = new int[10];
        A[0] = 1;A[1] = 3;A[2] = 7;A[3]=10;
        int[] B = new int[10];
        B[0] = 0;B[1] = 9;B[2] = 33;
        Q1_SortedMerge test = new Q1_SortedMerge();
        test.merge(A, B, 4, 3);
        for(int i=0;i<7;i++) System.out.println(A[i]);
    }
}
