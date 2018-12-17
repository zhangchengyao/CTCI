package chapter2_LinkedList;

public class Test {
    public static void main(String[] args){
        Q5_SumLists test = new Q5_SumLists();
        ListNode list1 = new ListNode(7);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(6);
        list1.next.next.next = new ListNode(6);
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(9);
        list2.next.next = new ListNode(4);
        ListNode res = test.addTwoNumber(list1, list2);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
