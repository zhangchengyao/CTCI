package chapter17_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args){
        Q12_BiNode.BiNode root = new Q12_BiNode.BiNode(4);
        root.node1 = new Q12_BiNode.BiNode(2);
        root.node1.node2 = new Q12_BiNode.BiNode(3);
        root.node1.node1 = new Q12_BiNode.BiNode(1);
        root.node2 = new Q12_BiNode.BiNode(5);
        Q12_BiNode.BiNode res = new Q12_BiNode().convert(root);
        Q12_BiNode.BiNode cur = res;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.node2;
        }
    }
}
