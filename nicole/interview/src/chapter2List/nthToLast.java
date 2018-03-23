package chapter2List;

/**
 * @author NicoleChen
 * @date 2017/12/29 10:54
 * 找出单向链表中倒数第k个节点
 */
public class nthToLast {
    //方法一：迭代法
    public static int nthToLast(Node n,int k){
        Node p = n;
        Node q = n;
        int count = 1;
        if(n == null){
            return -1;
        }
       /* while (n.next != null && count != k){
            q = q.next;
            count++;
        }*/
        for(int i = 1; i<k; i++){
            if(q.next!=null){
                q=q.next;
            }
        }
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        return p.data;

    }
    /*public static int nthToLast(Node n,int k){
    //方法二：递归，占O(n)空间，无法同时返回计数器和节点值i，只能在函数内打印，无法控制
        if(n == null){
            return -1;
        }
        int i = nthToLast(n.next, k) + 1;
        if(i == k){
            //return n.data;
            System.out.println(n.data);
        }
        return i;

    }*/

  /*  public static Node nthToLast(Node n,int k, IntWrapper i){
       //方法三：用一个简单的类包裹计数器值，模仿C的引用传值
        if(n == null){
            return  null;
        }
        Node p = nthToLast(n.next, k, i);
        i.value = i.value+1;
        if(i.value == k){
            return n;
        }
        return p;
    }*/
    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(9);
        Node node6 = new Node(4);
        Node node7 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        System.out.println(nthToLast(node1,3));//1
        //nthToLast(node1,3);//2
       /* IntWrapper i = new IntWrapper();//3
        i.value = 0;
        Node node = nthToLast(node1,3, i);
        System.out.println(node.data);*/


    }
}
 class IntWrapper{
    public int value = 0;
}
