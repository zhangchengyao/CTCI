package chapter2_LinkedList;

public class Q5_SumLists {
    ListNode addTwoNumber(ListNode head1, ListNode head2){
        ListNode newHead = null;
        ListNode cur = null;
        ListNode p = head1;
        ListNode q = head2;
        int carry = 0;
        while(p!=null || q!=null){
            int a = p==null?0:p.val;
            int b = q==null?0:q.val;
            int sum = a+b+carry;
            if(newHead==null){
                newHead = new ListNode(sum%10);
                cur = newHead;
            }else{
                cur.next = new ListNode(sum%10);
                cur = cur.next;
            }
            carry = sum/10;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        return newHead;
    }
}
