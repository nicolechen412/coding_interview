package chapter2List;

import java.util.Hashtable;


/**
 * @author NicoleChen
 * @date 2017/12/22 10:17
 * 移除未排序链表中的重复节点
 *
 */
public class deleteDups {

    public static Node deleteDups(Node n){
        //方法一:记录重复元素可以使用Hashtable，可以只需一次遍历
       /*Hashtable hashtable = new Hashtable();
       Node head = new Node(-1);
       head.next = n;
       Node tmp = head;
       while(n!= null){
           if(!hashtable.containsKey(n.data)){
               hashtable.put(n.data,true);
               n = n.next;
               tmp = tmp.next;
           }else {
               n = n.next;
               tmp.next = n;
           }
       }
       return head.next;*/
       //方法二：不使用缓冲区
        Node head = new Node(-1);
        //Node current = n;
        head.next = n;
        Node runner;
        while (n != null){
            runner = n;
            while (runner.next != null){
                if(runner.next.data != n.data){
                    runner = runner.next;
                }else {
                    runner.next = runner.next.next;
                }
            }
            n = n.next;
        }
        return head.next;
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
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
        node6.next = node7;
        //Node node1 = null;


        Node.showList(deleteDups(node1));
    }
}

