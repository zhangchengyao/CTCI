package chapter2_LinkedList;

public class Test {
    public static void main(String[] args){
        Q7_Intersection test = new Q7_Intersection();
        ListNode list1 = new ListNode(1);
        int i = 2;
        ListNode cur = list1;
        for(int j=0;j<6;j++){
            cur.next = new ListNode(i++);
            cur = cur.next;
        }
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(9);
        list2.next.next = list1.next.next.next;
//        ListNode res = test.addTwoNumber(list1, list2);
//        while(res!=null){
//            System.out.println(res.val);
//            res = res.next;
//        }
        System.out.println(test.findIntersectingNode(list1, list2).val);
    }
}
