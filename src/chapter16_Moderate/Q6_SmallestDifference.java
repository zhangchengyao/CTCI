package chapter16_Moderate;

import java.util.Arrays;

public class Q6_SmallestDifference {
    int findSmallestDiff(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);

        int pa = 0;
        int pb = 0;
        int minDiff = Integer.MAX_VALUE;
        while(pa<A.length && pb<B.length){
            minDiff = Math.min(minDiff, Math.abs(A[pa]-B[pb]));
            if(A[pa]<B[pb]) pa++;
            else pb++;
        }
        return minDiff;
    }
}
