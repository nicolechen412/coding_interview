package newCoder;


import java.util.Stack;

/**
 * @author NicoleChen
 * @date 2018/5/17 13:17
 */
public class Code_04_List {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }
    public static class IsPalindromeList {
        public boolean isPalindrome1(Node head) {    //方法1:空间O(n)
            if (head == null || head.next == null) {
                return true;
            }
            Stack<Node> stack = new Stack<>();
            Node p = head;
            stack.push(p);
            while (p != null) {
                stack.push(p);
                p = p.next;

            }

            Node q = head;
            while (!stack.isEmpty() && q.next != null) {
                if (stack.pop().value != q.value) {
                    return false;
                }
                q = q.next;
            }
            return true;
        }

        public boolean isPalindrome2(Node head) {       //方法2:空间O(n/2)
            if (head == null || head.next == null) {
                return true;
            }
            Node fast = head;
            Node slow = head.next;
            while (fast.next!= null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            Stack<Node> stack = new Stack<>();

            while(slow.next != null){
                slow = slow.next;
                stack.push(slow);
            }
            Node cur = head;
            while(!stack.isEmpty()){
                if(stack.pop().value != cur.value){
                    return false;
                }
                cur = cur.next;
            }

            return true;
        }
         /*   Node slow = head.next;      //方法2参考：不判断奇数链表的最中间的节点值
            Node fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Stack<Node> stack = new Stack<Node>();
            while (slow != null) {
                stack.push(slow);
                slow = slow.next;
            }
            while (!stack.isEmpty()) {
                if (head.value != stack.pop().value) {
                    return false;
                }
                head = head.next;
            }
            return true;
        }*/
         public boolean  isPalindrome3(Node head){
             Node fast = head;
             Node slow = head;
             while (fast.next!= null && fast.next.next != null) {
                 slow = slow.next;
                 fast = fast.next.next;
             }

             Node p =  slow.next;     //将链表逆序，复杂
             fast = p.next;
             p.next = slow;
             slow.next = null;
             slow = p;
             p = fast;
             while(p != null){
                 fast = p.next;
                 p.next = slow;
                 slow = p;
                 p = fast;
             }
             fast = slow;
             p = head;
             boolean res = true;
             while(slow != null){
                 if(slow.value != p.value){
                     res =  false;
                     break;
                 }
                 slow = slow.next;
                 p = p.next;
             }

             p = fast.next;
             slow = p.next;
             fast.next = null;
             while(p != null){
                 slow = p.next;
                 p.next = fast;
                 fast = p;
                 p = slow;


             }
             /*while(slow != null){
                 System.out.println(slow.value);
                 slow = slow.next;
             }*/
             while(head != null){
                 System.out.println(head.value);
                 head = head.next;
             }




             return res;
         }
    }


    public static class SmallerEqualBigger{
        public Node ListPartition(Node head, int pivot){
            Node n = head;
            int count = 0;
            while(n != null){
                count++;
                n = n.next;
            }
            n = head;
            Node[] arr = new Node[count];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = n;
                n = n.next;
            }
            int first = -1;
            int end = arr.length;
            int cur = 0;
            while(cur < end){
                /*if(arr[cur].value < pivot){
                    wrongSwap(arr[++first].value, arr[cur++].value);
                }else if(arr[cur].value > pivot){
                    wrongSwap(arr[cur].value, arr[--end].value);
                }else{
                    cur++;
                }*/
                if(arr[cur].value < pivot){
                    swap(arr,++first, cur++);
                }else if(arr[cur].value > pivot){
                    swap(arr,cur, --end);
                }else{
                    cur++;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i].value);
            }
            Node node = new Node(-1);

            for (int i = 1; i < arr.length; i++) {
                arr[i-1].next = arr[i];
            }

            return node;
        }

        private void swap(Node[] arr, int a, int b) {
            Node c = arr[a];
            arr[a] = arr[b];
            arr[b] = c;
        }
       private void wrongSwap(int a, int b) {  //错误方式：没有修改原数组
           int c = a;
           a = b;
           b = c;
       }
       public void ListPartition2(Node head, int pivot){
            Node less = new Node(-1);
            Node equal = new Node(-1);
            Node more = new Node(-1);
            Node n = head;
            Node i = equal;
            Node j = more;
            while(n != null){
                if(n.value < pivot){
                    less.next = n;
                    less = less.next;
                }else if(n.value == pivot){
                    equal.next = n;
                    equal = equal.next;
                }else{
                    more.next = n;
                    more = more.next;
                }
                n = n.next;
            }

            less.next = i.next;
            equal.next = j.next;

            while(head != null){
                System.out.println(head.value);
                head = head.next;
            }
       }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(9);
        Node n3 = new Node(35);
        Node n4 = new Node(6);
        Node n5 = new Node(1);
        Node n6 = new Node(8);
        Node n7 = new Node(12);
        Node n8 = new Node(56);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        //IsPalindromeList palindromeList = new IsPalindromeList();
        //System.out.println(palindromeList.isPalindrome1(n1));
        //System.out.println(palindromeList.isPalindrome2(n1));
        //System.out.println(palindromeList.isPalindrome3(n1));
        //palindromeList.isPalindrome3(n1);
        SmallerEqualBigger seb = new SmallerEqualBigger();
        /*Node p = seb.ListPartition(n1,3);
        while(p.next != null){
            p = p.next;
            System.out.println(p.value);*/
        seb.ListPartition2(n1,9);

        }


}
