package chapter2_LinkedList;

public class Q3_DeleteMiddleNode {
    boolean deleteMiddleNode(ListNode node){
        if(node==null || node.next==null) return false;
        node.val = node.next.val;
        node.next = node.next.next;
        return true;
    }
}
