package chapter2_LinkedList;

public class Q8_LoopDetection {
    ListNode getBeginningOfLoop(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null & fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }

        if(fast==null || fast.next==null) return null;

        slow = head;
        while(fast!=slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
