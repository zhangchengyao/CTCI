package chapter2_LinkedList;

import java.util.Stack;

public class Q6_Palindrome {
    boolean isPalindrome(ListNode head){
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){
            // odd length
            slow = slow.next;
        }
        while(slow!=null){
            if(slow.val!=stack.pop()) return false;
            slow = slow.next;
        }
        return true;
    }
}
