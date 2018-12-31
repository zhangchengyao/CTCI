package chapter10_SortingAndSearching;

public class Test {
    public static void main(String[] args){
        String[] strs = {"abcda", "iiiooo", "bcaad", "ioioio"};
        Q2_GroupAnagrams test = new Q2_GroupAnagrams();
        test.groupAnagrams(strs);
        for(String s: strs) System.out.println(s);
    }
}
