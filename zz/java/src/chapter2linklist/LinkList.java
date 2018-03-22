package chapter2linklist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static java.lang.System.out;
/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/20 16:00
 */
public class LinkList {
    public int value;
    public LinkList next;

    public LinkList(int value) {
        this.value = value;
    }

    public static void main(String[] args){
        LinkList node1 = new LinkList(3);
        LinkList node2 = new LinkList(1);
        LinkList node3 = new LinkList(5);
        LinkList node4 = new LinkList(5);
        LinkList node5 = new LinkList(1);
        LinkList node6 = new LinkList(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
//        out.println(addToTail(null, 2).value);
        showList(node1);
//        showList(delDuplica2_1(head));
//        System.out.println(lastKNode2_2(node1, 2).value);
//        showList(delMiddleNode2_3(node1, node3));
//        showList(splitByX2_4(node1, 2));
//        circleStartNode2_6(node1);
        huiwenList2_7(node1);
    }


    public static LinkList addToTail(LinkList head, int value) {
        if(head == null){
            head = new LinkList(value);
        }else {
            LinkList tail = new LinkList(value);
            LinkList tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = tail;
        }
        return head;
    }

    public static LinkList delByValue(LinkList head, int value){
        if(head == null)
            return null;
        LinkList pre = new LinkList(-1);
        pre.next = head;
        LinkList tmp = pre;
        while(tmp.next != null){
            if(tmp.next.value == value){
                tmp.next = tmp.next.next;
                break;
            }else{
                tmp = tmp.next;
            }
        }
        return pre.next;

    }


    public static void showList(LinkList head){
        if(head == null){
            out.println("Empty LinkList");
            return;
        }
        while(head != null){
            out.print(head.value + "\t");
            head = head.next;
        }
        out.println();
    }

    public static LinkList delDuplica2_1(LinkList head){
        if(head == null)
            return null;
        LinkList pre = new LinkList(-1);
        pre.next = head;

        HashMap<Integer, Integer> map = new HashMap<>();
        while(pre.next != null){
            if(map.containsKey(pre.next.value)){
                pre.next = pre.next.next;
            }else{
                map.put(pre.next.value, 1);
            }
            pre = pre.next;
        }
        return head;
    }

    public static LinkList lastKNode2_2(LinkList head, int k){
        if(head == null)
            return null;

        LinkList firstWalker = head;
        LinkList secondWalker = head;

        while(k-- != 0){
            if(firstWalker == null){
                System.out.println("Don't have enough node");
                return null;
            }
            firstWalker = firstWalker.next;
        }
        while(firstWalker != null){
            firstWalker = firstWalker.next;
            secondWalker = secondWalker.next;
        }
        return secondWalker;
    }

    public static LinkList delMiddleNode2_3(LinkList head, LinkList node){
        while(node.next != null){
            node.value = node.next.value;
            if(node.next.next == null){
                node.next = null;
                break;
            }
            node = node.next;
        }
        return head;
    }

    public static LinkList splitByX2_4(LinkList head, int x){
        if(head == null)
            return null;
        LinkList beforeList = new LinkList(-1);
        LinkList afterList = new LinkList(-1);
        LinkList tmpBefore = beforeList;
        LinkList tmpAfter = afterList;

        while(head != null){
            int value = head.value;
            if(value <= x){
                tmpBefore.next = head;
                tmpBefore = tmpBefore.next;
            }else{
                tmpAfter.next = head;
                tmpAfter = tmpAfter.next;
            }
            head = head.next;
        }
        tmpBefore.next = afterList.next;
        return beforeList.next;
    }

    public static void circleStartNode2_6(LinkList head){
        if(head == null)
            return;
        Set<Integer> set = new HashSet<>();
        while(head != null){
            int value = head.value;
            if(set.contains(value)){
                out.println(value);
                break;
            }else{
                set.add(value);
            }
            head = head.next;
        }

    }

    public static void huiwenList2_7(LinkList head){
        if(head == null)
            return;
        Stack<Integer> stack = new Stack<>();
        LinkList fastWalker = head;
        LinkList slowWalker = head;
        while(fastWalker != null && fastWalker.next != null && fastWalker.next.next != null){
            fastWalker = fastWalker.next.next;
            stack.push(slowWalker.value);
            slowWalker = slowWalker.next;
        }
        if(fastWalker.next != null){//奇数个节点
            stack.push(slowWalker.value);
        }

        slowWalker = slowWalker.next;
        while(slowWalker != null){
            int value = slowWalker.value;
            int popValue = stack.pop();
            if(value != popValue){
                System.out.println("Not a Huiwen List");
                return;
            }
            slowWalker = slowWalker.next;
        }
        System.out.println("It's a Huiwen List");
    }
}
