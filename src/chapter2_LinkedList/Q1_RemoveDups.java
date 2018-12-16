package chapter2_LinkedList;

import java.util.HashSet;

public class Q1_RemoveDups {
    void removeDups(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        HashSet<Integer> set = new HashSet<>();
        while(cur!=null){
            if(set.contains(cur.val)){
                prev.next = cur.next;
            }else{
                prev = cur;
                set.add(cur.val);
            }
            cur = cur.next;
        }
    }
}
