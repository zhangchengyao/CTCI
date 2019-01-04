package chapter16_Moderate;

import java.util.HashMap;

public class Q25_LRUCache {
    private ListNode head;
    private ListNode tail;
    private int size;
    private HashMap<Integer, ListNode> map;

    Q25_LRUCache(int maxSize){
        size = maxSize;
        map = new HashMap<>();
    }

    String get(int key){
        if(!map.containsKey(key)){
            return null;
        } else {
            ListNode node = map.get(key);
            if(head!=node){
                removeNode(node);
                insertFirst(node);
            }
            return node.val;
        }
    }

    void put(int key, String value){
        ListNode node = new ListNode(key, value);
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }
        map.put(key, node);
        insertFirst(node);
        if(map.size()>size) removeLast();
    }

    boolean remove(int key){
        if(map.containsKey(key)){
            removeNode(map.get(key));
            map.remove(key);
            return true;
        } else {
            return false;
        }
    }

    private void removeNode(ListNode node){
        if(map.size()==1){
            head = null;
            tail = null;
        } else {
            node.prev.next = node.next;
            if(tail==node) {
                tail = node.prev;
            } else {
                node.next.prev = node.prev;
            }
        }
    }

    private void insertFirst(ListNode node){
        if(head==null){
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.prev = null;
            node.next = head;
            head = node;
        }
    }

    private void removeLast(){
        map.remove(tail.key);
        if(head==tail){
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    class ListNode{
        int key;
        String val;
        ListNode prev;
        ListNode next;
        ListNode(int _key, String _val){
            key = _key;
            val = _val;
        }
    }
}
