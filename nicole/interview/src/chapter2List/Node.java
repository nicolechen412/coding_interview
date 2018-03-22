package chapter2List;

/**
 * @author NicoleChen
 * @date 2017/12/20 21:45
 * java:linkedlist
 */
public class Node {
    Node next = null;
    int data;

    public Node() {
    }

    public Node(int d){
        this.data = d;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public static void showList(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    Node deleteNode(Node head, int d){
        Node n = head;
        if(n.data == d){
            return head.next;
        }

        while(n.next != null){
            if (n.next.data == d){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
