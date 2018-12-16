package chapter2_LinkedList;

public class Q2_ReturnKth {
    ListNode returnKthToLast(ListNode head, int k){
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<k;i++){
            if(fast==null) return null;
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
