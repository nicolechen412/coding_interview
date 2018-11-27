package autumnExam.newCoder;

import java.util.HashMap;

/**
 * @author NicoleChen
 * @date 2018/5/24 10:22
 *
 *
 * Node类中的value是节点值，next指针和正常单链表中next指针的意义一样，都指向下一个节点，rand指针是Node类中新增的指针，这个指针可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由 Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
 *
 */
public class Code_04_CopyListWithRandom {
    public static class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node CopyListWithRand1(Node head){
        if(head == null){
            return null;
        }
        HashMap<Node,Node> hashMap = new HashMap();
        Node cur = head;
        while(cur != null){
            hashMap.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            hashMap.get(cur).next = cur.next;
            hashMap.get(cur).rand = cur.rand;
            cur = cur.next;
        }

        return hashMap.get(head);
    }
    public static Node CopyListWithRand2(Node head){   //不使用额外的数据结构，只用有限几个变量，在时间复杂度O(N)内
        if(head == null){    //注意开始的判断条件
            return null;
        }
        //copy node
        Node n = head;
        Node tmp = null;
        while(n != null){
            tmp = new Node(n.value);
            tmp.next = n.next;
            n.next = tmp;
            n = n.next.next;
        }
        //copy node.rand and random
        n = head;
        while(n != null){
            tmp = n.next;
            /*if(n.rand == null) {
                tmp.rand = null;
            }else{
                tmp.rand = n.rand.next;
            }*/
            tmp.rand = (n.rand == null ? null : n.rand.next);

            n = n.next.next;
        }
        //split new and old node
        n = head;
        tmp = head.next;
        Node res = head.next;
        while(tmp.next != null){
            n.next = n.next.next;
            tmp.next = tmp.next.next;
            n = n.next;
            tmp = tmp.next;
        }
        n.next = null;
        return head;
    }
    private static void printRandLinkedList(Node n) {
        while(n != null){
            System.out.println(n.value +  " rand: " + ((n.rand == null)?"-": n.rand.value));
            n = n.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.rand = head.next.next;
        head.next.rand = head;
        head.next.next.rand = null;
        head.next.next.next.rand = null;
        head.next.next.next.next.rand = head.next.next;

        //printRandLinkedList(head);
        //Node n = CopyListWithRand1(head);
        Node n = CopyListWithRand2(head);
        printRandLinkedList(n);

    }


}
