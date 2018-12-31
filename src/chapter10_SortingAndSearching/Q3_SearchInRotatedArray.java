package chapter10_SortingAndSearching;

public class Q3_SearchInRotatedArray {
    int search(int[] array, int val){
        return search(array, 0, array.length-1, val);
    }

    private int search(int[] array, int left, int right, int x){
        if(left>right) return -1;

        int mid = left + (right-left)/2;
        if(array[mid]==x) return mid;

        if(array[left]<array[mid]){
            if(array[left]<=x && x<array[mid]) return search(array, left, mid-1, x);
            else return search(array, mid+1, right, x);
        } else if(array[left]>array[mid]){
            if(array[mid]<x && x<=array[right]) return search(array, mid+1, right, x);
            else return search(array, left, mid-1, x);
        } else {
            if(array[mid]!=array[right]){
                return search(array, mid+1, right, x);
            } else {
                int res = search(array, left, mid-1, x);
                if(res == -1){
                    return search(array, mid+1, right, x);
                } else {
                    return res;
                }
            }
        }
    }
}
