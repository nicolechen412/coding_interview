package chapter3StackAndQueue;

/**
 * @author NicoleChen
 * @date 2017/12/22 15:05
 * 使用链式存储实现栈（Node）
 */
/*public class Stack {
    Node top;
    int pop(){
        if(top != null){
            int item = top.data;
            top = top.next;
            return item;
        }
        return -1;
    }

    void push(int item){
        Node t = new Node(item);
        t.next = top;//top位于链表的开始位置，将t与top所在的链表相连
        top = t;
    }

    int peek(){          //查看栈顶元素但不删除
        return top.data;
    }
}*/

public class Stack {

    private Node top;
    private int size;

    public int length(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public Stack(){
        top = null;
    }
    int pop(){
        if(top == null){
            throw new RuntimeException("空栈异常");
        }else{
            int item = top.data;
            top = top.next;
            size--;
            return item;
        }
    }

    void push(int item){
        Node n = new Node(item);
        n.next = top;
        top = n;
        //top = new Node(item);
        size++;
    }
    int peek(){
        if(isEmpty()){
            throw new RuntimeException("空栈异常");
        }else {
            return top.data;
        }
    }

    boolean isfull(){
        if (size == 100){
            return true;
        }else{
            return false;
        }
    }
}
