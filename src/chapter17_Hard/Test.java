package chapter17_Hard;

import java.util.*;

public class Test {
    public static void main(String[] args){
        Q13_ReSpace test = new Q13_ReSpace();
        String str = "jesslookedjustliketimherbrother";
        List<String> list = Arrays.asList("looked","just","like","her","brother");
        HashSet<String> dic = new HashSet<>(list);
        List<String> res = test.unconcatenate(str, dic);
        System.out.println(res);
    }
}
