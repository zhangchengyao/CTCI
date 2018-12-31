package chapter10_SortingAndSearching;

public class Q4_SortedSearchNoSize {
    class Listy{
        int elementAt(int i){ return i; }
    }

    int search(Listy list, int val){
        int right = 1;
        while(list.elementAt(right)!=-1 && list.elementAt(right)<val) right *= 2;

        int left = right/2;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(list.elementAt(mid)==val) return mid;
            else if(list.elementAt(mid)!=-1 && list.elementAt(mid)<val) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
