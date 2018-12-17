package chapter2_LinkedList;

public class Q7_Intersection {
    ListNode findIntersectingNode(ListNode head1, ListNode head2){
        if(head1==null || head2==null) return null;
        int len1 = 1;
        int len2 = 1;
        ListNode cur = head1;
        while(cur.next!=null){
            len1++;
            cur = cur.next;
        }
        ListNode end = cur;
        cur = head2;
        while(cur.next!=null){
            len2++;
            cur = cur.next;
        }
        // has intersection
        if(end==cur){
            ListNode p = head1;
            ListNode q = head2;
            if(len1>len2){
                for(int i=0;i<len1-len2;i++) p = p.next;
            }else{
                for(int i=0;i<len2-len1;i++) q = q.next;
            }
            while(p!=q){
                p = p.next;
                q = q.next;
            }
            return p;
        }else{
            return null;
        }
    }
}
