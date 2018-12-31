package chapter10_SortingAndSearching;

import java.util.Arrays;

public class Q1_SortedMerge {
    void merge(int[] A, int[] B, int lenA, int lenB){
        int end = lenA+lenB-1;
        int idxA = lenA-1;
        int idxB = lenB-1;

        while(idxB>=0){
            if(idxA>=0 && A[idxA]>B[idxB]) A[end--] = A[idxA--];
            else A[end--] = B[idxB--];
        }
    }

}
