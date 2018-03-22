package chapter3stackqueue;

import chapter2linklist.LinkList;

import static java.lang.System.out;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/22 19:30
 */
public class LinkQueue {
    public static LinkList left, right;

    public static void enque(int value){
        if(left == null){
            right = new LinkList(value);
            left = right;
        }else{
            LinkList node = new LinkList(value);
            right.next = node;
            right = node;
        }
    }

    public static int deque(){
        if(left == null || right == null){
            out.println("Empty queue");
            return -1;
        }
        int value = left.value;
        left = left.next;
        return value;
    }

    public static void main(String[] args){
        enque(1);
        enque(2);
        enque(3);
        out.println(deque());
        out.println(deque());
        out.println(deque());
        out.println(deque());
        enque(100);
        out.println(deque());
    }
}
