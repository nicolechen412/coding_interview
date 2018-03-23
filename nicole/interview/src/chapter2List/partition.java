package chapter2List;

/**
 * @author NicoleChen
 * @date 2017/12/29 14:26
 * 以给定值x为基准将链表分割成两部分，所有小于x的节点排在大于等于x的节点之前
 */
public class partition {
    //方法一：维护四个变量
    /*public static Node partition(Node n, int x){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        while (n != null){
            Node next = n.next;
            n.next = null;
            if(n.data < x){
                if(beforeStart == null) {
                    beforeStart = n;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = n;
                    beforeEnd = n;
                }
            }else {
                if(afterStart == null){
                    afterStart = n;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = n;
                    afterEnd = n;
                }
            }
            n = next;
        }
        if(beforeStart == null){
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;

    }*/
    //方法二：节点追加到两个链表的前端。减少为两个变量。遍历链表时间变长，但时间复杂度不变

    public static Node partition(Node n, int x){
        Node beforeStart = null;
        Node afterStart = null;
        while (n != null){
            Node next = n.next;
            if(n.data < x){
                    n.next = beforeStart;
                    beforeStart = n;
            }else {
                    n.next = afterStart;
                    afterStart = n;
            }
            n = next;
        }
        if(beforeStart == null){
            return afterStart;
        }
        Node head = beforeStart;
        while (beforeStart.next != null){
            beforeStart = beforeStart.next;
        }
        beforeStart.next = afterStart;
        return head;
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(9);
        Node node3 = new Node(7);
        Node node4 = new Node(3);
        Node node5 = new Node(2);
        Node node6 = new Node(4);
        Node node7 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node.showList(partition(node1,5));
    }
}

