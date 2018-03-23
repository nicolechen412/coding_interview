package chapter3StackAndQueue;

/**
 * @author NicoleChen
 * @date 2018/3/13 13:18
 */
public class Queue2 {
    private int[] data = null;
    private int first;
    private int last;
    private int maxSize;


    Queue2(){
        this(10);
    }
    Queue2(int initialSize){
        if(initialSize < 0){
            throw new RuntimeException("初始化大小不能小于0:"+ initialSize);
        }else{
            maxSize = initialSize;
            data = new int[maxSize];
            first = last = 0;
        }

    }
    public boolean empty(){
        return first == last;
    }
    public boolean enqueue(int item){
        if(last - first == maxSize){
            throw new RuntimeException("队列已满");
        }else{
            data[last++] = item;
            return true;
        }

    }
    public int dequeue(){
        if(empty()){
            throw new RuntimeException("空队列");
        }else{
            int item = data[first++];
            return item;
        }

    }
    public int peek(){
        if(empty()){
            throw new RuntimeException("空队列");
        }else{
            return data[first];
        }
    }
}
