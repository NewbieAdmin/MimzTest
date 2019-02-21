package newbie.base.exercises;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {

    /**
     * 自定义链表
     */
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private static Node head;

    /**
     * 逆转方法
     * @param node
     */
    private static Node reverse(Node node) {
        if(null == node || null == node.next){
            return null;
        }
        Node p1 = node;
        Node p2 = node.next;
        Node p3 = null;
        while(null != p2){
            p3 = p2.next; // 将p3的值保存出来
            p2.next = p1; // 结点指向逆转
            // 向后移一位
            p1 = p2;
            p2 = p3;
        }
        node.next = null;
        // 将逆转后的Node重新赋值给原有的Node
        node = p1;
        return node;
    }

    private static void printf(Node node){
        Node temp = node;
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        while(null != temp){
            sb.append(temp.data).append(",");
            temp = temp.next;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        System.out.println(sb.toString());
    }

    /**
     * 倒转链表
     * @param args
     */
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        Collections.reverse(list);

        Node node = new Node(1);
        node.next = new Node(2);
        Node temp = node.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(5);
        temp = node;

        System.out.printf("逆转前： ");
        printf(temp);

        temp = reverse(temp);

        System.out.printf("逆转后： ");
        printf(temp);

    }

}
