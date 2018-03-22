package chapter2List;



/**
 * @author NicoleChen
 * @date 2017/12/25 11:05
 * 1-2-3-3-4-4-5,处理后：1-2-5
 */
public class deleteDups2 {
    public static Node deleteDups2(Node n ){

        Node head = new Node(-1);
        Node current = head;
        Node p = n;
        head.next = n;
        int flag = -1;
        if(n == null){
            return null;
        }
        while(p.next != null){
            if(p.data != p.next.data && p.data != flag){
                flag = p.data;
                current.next = p;
                p = p.next;
                current = current.next;
            }else {
                flag = p.data;
                p = p.next;
            }
        }
        if(p.data != flag){
            current.next= p;
        }else {
            current.next= null;
        }
        return head.next;
    }
    public static void main(String[] args) {
        /*Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(4);
        Node node6 = new Node(4);
        Node node7 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;*/
        Node node1 = null;


        Node.showList(deleteDups2(node1));
    }
}

