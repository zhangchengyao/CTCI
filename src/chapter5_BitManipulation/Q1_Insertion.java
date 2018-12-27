package chapter5_BitManipulation;

public class Q1_Insertion {
    int insert(int N, int M, int i, int j){
        M <<= i;

        int len = j-i+1;
        int mask = (1<<len)-1;
        mask = ~(mask<<i);

        N = (N & mask) | M;
        return N;
    }
}
