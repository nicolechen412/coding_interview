package chapter4TreeandPic;

/**
 * @author NicoleChen
 * @date 2018/3/13 13:18
 */
public class Queue {
    private Node[] data = null;
    private int first;
    private int last;
    private int maxSize;



    Queue(){
        this(10);
    }
    Queue(int initialSize){
        if(initialSize < 0){
            throw new RuntimeException("初始化大小不能小于0:"+ initialSize);
        }else{
            maxSize = initialSize;
            data = new Node[maxSize];
            first = last = 0;
        }

    }
    public boolean empty(){
        return first == last;
    }
    public boolean enqueue(Node n){
        if(last - first == maxSize){
            throw new RuntimeException("队列已满");
        }else{
            data[last++] = n;

            return true;
        }

    }
    public Node dequeue(){
        if(empty()){
            throw new RuntimeException("空队列");
        }else{
            return  data[--last];

        }

    }
    public int peek(){
        if(empty()){
            throw new RuntimeException("空队列");
        }else{
            return data[first].data;
        }
    }
}
