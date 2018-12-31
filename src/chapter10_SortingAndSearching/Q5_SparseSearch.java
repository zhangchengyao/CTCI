package chapter10_SortingAndSearching;

public class Q5_SparseSearch {
    int search(String[] a, String val){
        if(a==null || a.length==0 || val==null || val.equals("")) return -1;

        int left = 0;
        int right = a.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(a[mid].isEmpty()) mid = getClosestNonEmpty(a, left, right, mid);
            if(mid==-1) return -1;

            if(a[mid].equals(val)) return mid;
            else if(a[mid].compareTo(val)<0) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }

    private int getClosestNonEmpty(String[] a, int left, int right, int idx){
        int i = idx-1;
        int j = idx+1;
        while(true){
            if(i<left && j>right) return -1;
            if(i>=left && a[i].length()>0) return i;
            if(j<=right && a[j].length()>0) return j;
            i--;
            j++;
        }
    }
}
