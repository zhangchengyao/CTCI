package chapter17_Hard;

public class Test {
    public static void main(String[] args){
        char[] arr = {'a','a','1','1','a','a','1','a','1'};
        char[] res = new Q5_LettersAndNumbers().longestSubarray(arr);
        for(char c: res) System.out.println(c);
    }
}
