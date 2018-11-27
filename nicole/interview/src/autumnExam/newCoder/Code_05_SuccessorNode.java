package autumnExam.newCoder;

/**
 * @author NicoleChen
 * @date 2018/6/7 10:55
 */
public class Code_05_SuccessorNode {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node successorNode(Node head){
        if(head.right != null){
            Node n = head.right;
            while(n.left != null){
                n = n.left;
            }
            return n;
        }else if(head.parent != null) {
            if(head == head.parent.left){
                return head.parent;
            }else{
                Node parent = head.parent;
                while(parent != null && head != parent.left){
                    head = parent;
                    parent = head.parent;
                }
                return parent;
            }
        }

        return null;
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.parent = null;

        n1.left = new Node(2);
        n1.left.parent = n1;
        n1.right = new Node(3);
        n1.right.parent = n1;

        n1.left.left = new Node(4);
        n1.left.left.parent = n1.left;
        n1.left.right = new Node(5);
        n1.left.right.parent = n1.left;

        n1.right.left = new Node(6);
        n1.right.left.parent = n1.right;
        n1.right.right = new Node(7);
        n1.right.right.parent = n1.right;

        Node node = successorNode(n1.right.left);
        if(node == null){
            System.out.println(node);
        }else{
            System.out.println(node.value);
        }
    }
}
