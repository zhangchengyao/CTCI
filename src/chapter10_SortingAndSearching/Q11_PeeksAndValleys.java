package chapter10_SortingAndSearching;

public class Q11_PeeksAndValleys {
    void sortValleyPeek(int[] array){
        for(int i=1;i<array.length;i+=2){
            int minIdx = getMinIdx(array, i-1, i, i+1);
            if(minIdx!=i) swap(array, i, minIdx);
        }
    }

    private int getMinIdx(int[] array, int l, int i, int r){
        if(r>=array.length) return array[i]<=array[l]?i:l;

        if(array[i]<=array[l] && array[i]<=array[r]) return i;
        else if(array[l]<=array[i] && array[l]<=array[r]) return l;
        else return r;
    }
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
