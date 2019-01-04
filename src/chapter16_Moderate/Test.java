package chapter16_Moderate;

import java.util.HashSet;
import java.util.List;

public class Test {
    public static void main(String[] args){
        Q25_LRUCache test = new Q25_LRUCache(5);
        test.put(1,"ou");
        test.put(2,"op");
        System.out.println(test.get(1));;
        test.put(3,"lk");
        test.put(4,"kk");
        test.put(5,"mn");
        test.put(6,"nb");
        System.out.println(test.get(2));
    }
}
