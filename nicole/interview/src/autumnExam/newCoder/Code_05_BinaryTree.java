package autumnExam.newCoder;


import java.util.LinkedList;
import java.util.Queue;
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
                Node c = null;      //当前stack栈顶节点，head为最近一次打印的节点
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
    public static String serialByPre(Node head){       //树的序列化
       /* if(head == null){
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;*/
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        String res = new String();
        while(stack.size() != 0){
            Node node = stack.pop();
            if(node == null){
                res += "#_";
            }else{
                res += node.value + "_";
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return res;

    }
    public static Node reconByPreOrder(String preStr){
        String[] str = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            queue.offer(str[i]);
        }

        return reconPreString(queue);
    }

    private static Node reconPreString(Queue<String> queue) {
        String value = queue.poll();
        if(value.equals("")||value .equals("#")) return null;
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreString(queue);
        head.right = reconPreString(queue);
        return head;
    }

    public static String serialByLevel(Node head){
        return "";
    }
    public static String reconByLevel(Node head){
        return "";
    }

    public static boolean isBalance(Node head){          //三个参数需要：所在层数，是否平衡，子树高度。层数在调用递归时增加，是否平衡在判断子树时改变，高度将层数作为返回值。需要注意的是bool变量为了传递值要使用数组，否则bool变量无法返回
        int level = 1;
        boolean[] flag = new boolean[1];
        //boolean flag = true;
        flag[0] = true;

        getHeight(head, level+1, flag);

        return flag[0];
        //return flag;
    }

    private static int getHeight(Node head, int level, boolean[] flag) {
        if(head == null) return level;
        int LH = getHeight(head.left, level+1, flag);
        if(!flag[0]) return level;
        //if(!flag) return level;
        int RH = getHeight(head.right, level+1, flag);
        if(!flag[0]) return level;
        //if(!flag) return level;
        if(Math.abs(LH-RH) > 1)
            flag[0] = false;
            //flag = false;
        return Math.max(LH, RH);
    }


    public static boolean isBST(Node head){                //判断搜索树是否正确

        //Queue<Integer> queue = new LinkedList<>();           //方法一
//        LinkedList<Integer> list = new LinkedList<>();
//        list = traversal(head,list);
//        int[] arr = new int[list.size()];
//        int count = 0;
//        for (int i = 0; i < list.size()-1; i++) {
//            if(list.get(i) > list.get(i+1)) return false;
//        }
        int pre = Integer.MIN_VALUE;                     //方法二
        if(head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    if(pre < head.value){
                        pre = head.value;
                    }else{
                        return false;
                    }

                    System.out.println(head.value);
                    head = head.right;
                }

            }
        }





        return true;


    }

    private static LinkedList traversal(Node head, LinkedList<Integer> list) {
        //int pre = Integer.MIN_VALUE;
        if(head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    list.add(head.value);
                    System.out.println(head.value);
                    head = head.right;
                }

            }
        }
        //System.out.println(queue.size());
        return list;


    }

    public static void printTreeByRow(Node head){               //按行打印一棵树就用队列
        Node last;
        Node nlast;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        //System.out.print(head.value);
        //System.out.println();
        last = head;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            nlast = node;
            System.out.print(node.value+ " ");
            if(last.right == nlast || last == nlast){
                System.out.println();
                last = nlast;
            }
            //Node node = queue.peek();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);

        }
    }
    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "down " : "up ");
        printProcess(i + 1, N, false);
    }


    public static void main(String[] args) {
     /*   Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        //n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        //n5.left = n10;
        //n5.right = n11;
        n6.left = n12;
        //n6.right = n13;
        n7.left = n14;*/

        Node n1 = new Node(10);     //搜索二叉树
        Node n2 = new Node(3);
        Node n3 = new Node(20);
        Node n4 = new Node(1);
        Node n5 = new Node(5);
        Node n6 = new Node(15);
        Node n7 = new Node(22);
//        Node n8 = new Node(8);
//        Node n9 = new Node(9);
//        Node n10 = new Node(10);
//        Node n11 = new Node(11);
//        Node n12 = new Node(12);
//        Node n13 = new Node(13);
//        Node n14 = new Node(14);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        n3.right = n7;
//        n4.left = n8;
//        n4.right = n9;
//        //n5.left = n10;
//        //n5.right = n11;
//        n6.left = n12;
//        //n6.right = n13;
//        n7.left = n14;

        //PreInPosTraversal.preOrderRecur(n1);
        //PreInPosTraversal.inOrderRecur(n1);
        //PreInPosTraversal.posOrderRecur(n1);
        //PreInPosTraversal.preOrderUnRecur(n1);
        //PreInPosTraversal.inOrderUnRecur(n1);
        //PreInPosTraversal.posOrderUnRecur2(n1);
        //String str = new String();
       // System.out.println(str = serialByPre(n1));
        //Node head = reconByPreOrder(str);
       // printTreeByRow(head);
        //System.out.println(isBalance(n1));
        //System.out.println(isCBT(n1));
        //System.out.println(isBST(n1));
        int N = 4;
        printAllFolds(N);


    }
}
