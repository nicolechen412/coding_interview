package chapter3stackqueue;

import static java.lang.System.out;
import chapter2linklist.LinkList;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/22 19:21
 */
public class LinkStack {
    public static LinkList stack;
    public static int min = 10000;

    public static void push(int value){
        if(value < min){
            min = value;
        }
        LinkList node = new LinkList(value);
        node.next = stack;
        stack = node;
    }

    public static int pop(){
        if(stack == null){
            System.out.println("Empty stack");
            return -1;
        }
        int value = stack.value;
        stack = stack.next;
        return value;
    }

    public static boolean isEmpty(){
        return stack == null ? true : false;
    }

    public static int min(){
        return min;
    }
    public static void main(String[] args){
        push(1);
        push(2);
//        out.println(pop());
//        out.println(pop());
//        out.println(pop());
        push(3);
//        out.println(pop());
        out.println(min());
    }

}
