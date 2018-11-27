package autumnExam.newCoder;

import java.util.HashSet;

/**
 * @author NicoleChen
 * @date 2018/5/24 17:27
 *
 * 单链表可能有环，也可能无环。给定两个单链表的头节点 head1和head2，这两个链表可能相交，也可能不相交。
 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null即可。
 * 要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到O(N+M)，额外空间复杂度请达到O(1)。
 *
 *
 */
public class Code_04_FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    private static Node getIntersectNode(Node head1, Node head2) {     //查看相交节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //System.out.println((loop1==null) + " " + (loop2==null));
        if(loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }else if(loop1 != null && loop2 != null){
            //System.out.println(1111111);
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    private static Node getLoopNode(Node head) {    //查找入环节点
        //1:hashset（简单） 2:快慢指针
        //1
        if(head == null){return null;}
        HashSet<Node> hashSet = new HashSet<>();
        Node n = head;
        while(n != null){
            if(hashSet.contains(n)){
                return n;
            }else{
                hashSet.add(n);
            }
            n = n.next;
        }
        return null;
        //2
        /*if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;

        while(fast != slow) {
            if (fast.next == null ||fast.next.next == null ) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;*/
    }

    private static Node noLoop(Node head1, Node head2) {
        int count = 0;
        Node n1 = head1;
        Node n2 = head2;
        while(n1 != null){
            count++;
            n1 = n1.next;
        }
        while(n2 != null){
            count--;
            n2 = n2.next;       //最后count为两个链表的长度差
        }
        Node n = count > 0 ? head1 : head2;    //n为较长链表，m为较短链表
        Node m = count > 0 ? head2 : head1;
        count = Math.abs(count);
        while(count != 0){
            n = n.next;
            count--;
        }

        while(n != null){
            if(n == m){
                return n;
            }
            n = n.next;
            m = m.next;
        }
        return null;

    }

    private static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        if(loop1 == loop2){
            int count = 0;
            Node n1 = head1;
            Node n2 = head2;
            while(n1 != loop1){
                count++;
                n1 = n1.next;
            }
            while(n2 != loop1){
                count--;
                n2 = n2.next;
            }
            Node n = count > 0 ? head1 : head2;
            Node m = count > 0 ? head2 : head1;
            count = Math.abs(count);
            while(count != 0){
                n = n.next;
                count--;
            }
            while(n != null){
                if(n == m){
                    return n;
                }
                n = n.next;
                m = m.next;
            }
            return null;
        }else {
            Node n = loop1.next;
            while(n != loop1){
                if(n == loop2){
                    return loop1;
                }
                n = n.next;
            }
            return null;
        }

    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        //getIntersectNode(head1,head2);
        //System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        //head2.next.next.next = head2.next; //8->9
        head2.next.next.next = head1.next; // 8->2
        //System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        //System.out.println(getIntersectNode(head1, head2));

        //0->9->8->6->7->4...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next.next; // 8->7
        Node q = null;
        if((q = getIntersectNode(head1, head2)) == null){
            System.out.println("null");
        }else{
            System.out.println(q.value);
        }

    }


}
