package chapter2_LinkedList;

public class Q4_Partition {
    void partitionList(ListNode head, int x){
        ListNode p = head;
        ListNode q;
        while(p!=null){
            if(p.val>=x){
                q = p.next;
                while(q!=null && q.val>=x) q = q.next;
                if(q==null) break;
                int tmp = p.val;
                p.val = q.val;
                q.val = tmp;
            }
            p = p.next;
        }
    }
}
