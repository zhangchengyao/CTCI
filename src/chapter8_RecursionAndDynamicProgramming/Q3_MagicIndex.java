package chapter8_RecursionAndDynamicProgramming;

public class Q3_MagicIndex {
//    int findMagicIndex(int[] A){
//        for(int i=0;i<A.length;i++){
//            if(A[i]==i) return i;
//            else if(A[i]>i) break;
//        }
//        return -1;
//    }
    int findMagicIndex(int[] A){
        int left = 0;
        int right = A.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(A[mid]==mid) return mid;
            else if(A[mid]>mid) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }

    int findMagicIndexWithDup(int[] A){
        return findMagicIndexWithDup(A, 0, A.length-1);
    }

    private int findMagicIndexWithDup(int[] A, int left, int right){
        if(left>right) return -1;

        int mid = left + (right-left)/2;

        if(A[mid]==mid) return mid;
        else{
            int magicLeft = findMagicIndexWithDup(A, left, Math.min(mid-1, A[mid]));
            return magicLeft==-1?findMagicIndexWithDup(A, Math.max(mid+1, A[mid]), right):magicLeft;
        }
    }
}
