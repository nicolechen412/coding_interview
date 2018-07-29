package ch3stackqueue;

import static java.lang.System.out;
import ch2linklist.LinkList;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/22 19:21
 */
public class LinkStack {
    public LinkList stack;
    public static int min = 10000;

    public void push(int value){
        if(value < min){
            min = value;
        }
        LinkList node = new LinkList(value);
        node.next = stack;
        stack = node;
    }

    public int pop(){
        if(stack == null){
            System.out.println("Empty stack");
            return -1;
        }
        int value = stack.value;
        stack = stack.next;
        return value;
    }

    public boolean isEmpty(){
        return stack == null ? true : false;
    }

    public static int min(){
        return min;
    }
    public static void main(String[] args){
        LinkStack linkStack = new LinkStack();

        linkStack.push(1);
        linkStack.push(2);
        out.println(linkStack.pop());
        out.println(linkStack.pop());
        out.println(linkStack.pop());
        linkStack.push(3);
//        out.println(pop());
        out.println(min());
    }

}
