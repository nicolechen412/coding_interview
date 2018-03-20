package chapter3StackAndQueue;



/**
 * @author NicoleChen
 * @date 2017/12/22 15:14
 * 先进先出
 */
public class Queue {
    /*Node first,last;
    void enqueue(int item){
        if(first == null){
            last = new Node(item);
            first = last;
        }else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    int dequeue(){
        if(first != null){
            int item = first.data;
            first = first.next;
            return item;
        }
        return 0;
    }*/

    Node first, last;
    int size;

    public Queue(){
        first = null;
        last = null;
    }
    public boolean empty(){
        return size==0;
    }
    public int length(){
        return size;
    }
    public boolean enqueue(int item){
        if(first == null){
            last = new Node(item);
            first = last;

        }else{
            last.next = new Node(item);
            last = last.next;
        }
        size++;
        return true;
    }

    public int dequeue(){
        if(first == null){
            throw new RuntimeException("空队列！");
        }else {
            int item = first.data;
            first = first.next;
            size--;
            return item;
        }
    }

    public int peek(){
        if(empty()){
            throw new RuntimeException("空队列");
        }
        return first.data;
    }
}
