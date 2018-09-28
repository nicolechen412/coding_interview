package newCoder;


import java.util.Stack;

/**
 * @author NicoleChen
 * @date 2018/5/28 19:39
 */
public class Code_05_BinaryTree {
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static class PreInPosTraversal{
        //递归方式
        public static void preOrderRecur(Node head){

            if(head != null){
                System.out.print(head.value + " ");
                preOrderRecur(head.left);
                preOrderRecur(head.right);
            }
        }
        public static void inOrderRecur(Node head){

            if(head != null){
                inOrderRecur(head.left);
                System.out.print(head.value + " ");
                inOrderRecur(head.right);
            }
        }
        public static void posOrderRecur(Node head){

            if(head != null){
                posOrderRecur(head.left);
                posOrderRecur(head.right);
                System.out.print(head.value + " ");
            }
        }
        //非递归方式
        public static void preOrderUnRecur(Node head){
            if(head != null){
                Stack<Node> stack = new Stack<>();
                stack.push(head);
                while(!stack.isEmpty()){
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    if(head.right != null){
                        stack.push(head.right);
                    }
                    if(head.left != null){
                        stack.push(head.left);
                    }
                }
            }

        }
        public static void inOrderUnRecur(Node head){        //比较难
            if(head != null){
                Stack<Node> stack = new Stack<>();
                while(!stack.isEmpty() || head != null){
                    if(head != null){
                        stack.push(head);
                        head = head.left;
                    }else{
                        head = stack.pop();
                        System.out.println(head.value);
                        head = head.right;
                    }
                }
            }
        }

        public static void posOrderUnRecur(Node head){         //难
            if(head != null){       //使用两个栈
                Stack<Node> s1 = new Stack<>();
                Stack<Node> s2 = new Stack<>();
                s1.push(head);
                while(!s1.isEmpty()){
                    head = s1.pop();
                    s2.push(head);
                    if(head.left != null){
                        s1.push(head.left);
                    }
                    if(head.right != null){
                        s1.push(head.right);
                    }
                }
                while(!s2.isEmpty()){
                    System.out.print(s2.pop().value + " ");
                }
            }
        }
        public static void posOrderUnRecur2(Node head){   //不使用两个栈
            if(head != null){
                Stack<Node> stack = new Stack<>();
                stack.push(head);
                Node c = null;
                while(!stack.isEmpty()){
                    c = stack.peek();
                    if(c.left != null && c.left != head && c.right != head){
                        stack.push(c.left);
                    }else if(c.right != null && c.right!= head){
                        stack.push(c.right);
                    }else{
                        System.out.print(stack.pop().value + " ");
                        head = c;
                    }
                }
            }
        }


    }
    public static String serialByPre(Node head){
        if(head == null){
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }
    public static String reconByPre(Node head){
        return "";
    }
    public static String serialByLevel(Node head){
        return "";
    }
    public static String reconByLevel(Node head){
        return "";
    }
    public static boolean isBalance(Node head){
        return false;
    }
    public static boolean isCBT(Node head){
        return false;
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        //PreInPosTraversal.preOrderRecur(n1);
        //PreInPosTraversal.inOrderRecur(n1);
        //PreInPosTraversal.posOrderRecur(n1);
        //PreInPosTraversal.preOrderUnRecur(n1);
        //PreInPosTraversal.inOrderUnRecur(n1);
        //PreInPosTraversal.posOrderUnRecur2(n1);
        System.out.println(serialByPre(n1));
    }
}
