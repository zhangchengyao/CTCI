package chapter2_LinkedList;

public class Q5_SumLists {
//    ListNode addTwoNumber(ListNode head1, ListNode head2){
//        ListNode newHead = null;
//        ListNode cur = null;
//        ListNode p = head1;
//        ListNode q = head2;
//        int carry = 0;
//        while(p!=null || q!=null){
//            int a = p==null?0:p.val;
//            int b = q==null?0:q.val;
//            int sum = a+b+carry;
//            if(newHead==null){
//                newHead = new ListNode(sum%10);
//                cur = newHead;
//            }else{
//                cur.next = new ListNode(sum%10);
//                cur = cur.next;
//            }
//            carry = sum/10;
//            if(p!=null) p = p.next;
//            if(q!=null) q = q.next;
//        }
//        if(carry==1) cur.next = new ListNode(1);
//        return newHead;
//    }

    // follow up
    class PartialSum{
        ListNode head;
        int carry;
    }
    ListNode addTwoNumber(ListNode head1, ListNode head2){
        int len1 = countLen(head1);
        int len2 = countLen(head2);
        if(len1>len2) head2 = padList(head2, len1-len2);
        else if(len2>len1) head1 = padList(head1, len2-len1);

        PartialSum res = helper(head1, head2);
        if(res.carry==1){
            ListNode node = new ListNode(1);
            node.next = res.head;
            res.head = node;
        }
        return res.head;
    }
    private PartialSum helper(ListNode head1, ListNode head2){
        if(head1==null || head2==null) return new PartialSum();

        PartialSum ps = helper(head1.next, head2.next);
        int val = ps.carry + head1.val + head2.val;
        ListNode newHead = new ListNode(val%10);
        newHead.next = ps.head;
        ps.head = newHead;
        ps.carry = val/10;
        return ps;
    }
    private int countLen(ListNode head){
        ListNode cur = head;
        int len = 0;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        return len;
    }
    private ListNode padList(ListNode head, int len){
        for(int i=0;i<len;i++){
            ListNode node = new ListNode(0);
            node.next = head;
            head = node;
        }
        return head;
    }
}
