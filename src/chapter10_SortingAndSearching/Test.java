package chapter10_SortingAndSearching;

public class Test {
    public static void main(String[] args){
        String[] a = {"cat","","","dog","","","","egg"};
        System.out.println(new Q5_SparseSearch().search(a, "egg"));
    }
}
