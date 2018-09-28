package chapter3StackAndQueue;

import java.util.Arrays;

/**
 * @author NicoleChen
 * @date 2018/3/13 14:12
 * 循环队列
 */
public class Queue3 {
    private int[] data = null;
    private int first;
    private int last;
    private int maxSize;
    private int size=0;

    Queue3(){
        this(10);
    }
    Queue3(int initialSize){
        if(initialSize < 0){
            throw new RuntimeException("初始化大小不能小于0:"+ initialSize);
        }else{
            maxSize = initialSize;
            data = new int[maxSize];
            first = last = 0;
        }

    }
    public boolean empty(){
        return size == 0 ;
    }
    public boolean enqueue(int item){
        if(size == maxSize){
            throw new RuntimeException("队列已满");
        }else{
            data[last] = item;
            //last = (last+1) % maxSize;
            last = last == maxSize-1 ? 0 : last+1;
            size++;
            return true;

        }

    }
    public int dequeue(){
        if(empty()){
            throw new RuntimeException("空队列");
        }else{
            int item = data[first];
            data[first] = item;
            //first = (first+1) % maxSize;
            first = first == maxSize-1 ? 0 : first+1;
            size--;
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
    public int length(){
        return size;
    }
    public void clear(){
        Arrays.fill(data,0);
        size=0;
        first=0;
        last=0;

    }
}
