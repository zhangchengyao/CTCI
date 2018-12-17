package chapter2_LinkedList;

public class Test {
    public static void main(String[] args){
        Q6_Palindrome test = new Q6_Palindrome();
        ListNode list1 = new ListNode(7);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(1);
        list1.next.next.next = new ListNode(7);
//        ListNode list2 = new ListNode(5);
//        list2.next = new ListNode(9);
//        list2.next.next = new ListNode(4);
//        ListNode res = test.addTwoNumber(list1, list2);
//        while(res!=null){
//            System.out.println(res.val);
//            res = res.next;
//        }
        System.out.println(test.isPalindrome(list1));
    }
}
