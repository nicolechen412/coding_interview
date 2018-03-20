package chapter3StackAndQueue;

/**
 * @author NicoleChen
 * @date 2018/3/12 15:25
 * 数组实现栈
 */
public class Stack2 {
    private int[] data = null;
    private int maxSize = 0;
    private int top = -1;

    public Stack2(){
        this(10);//调用自己的有参构造函数
    }
    public Stack2(int initialSize){
        if(initialSize >= 0){
            this.maxSize = initialSize;
            data = new int[initialSize];
            top = -1;
        }else{
            throw new RuntimeException("初始化大小不能小于0:"+ initialSize);
        }
    }

    public boolean empty(){
        return top == -1;
    }

    public boolean push(int item){
        if(top == maxSize -1){
            throw new RuntimeException("栈已满!");
        }else{
            data[++top] = item;
            return true;
        }
    }

    public int pop(){
        if(top == -1){
            throw new RuntimeException("栈为空！");
        }else{
            return data[top--];
        }
    }

    public int peek(){
        if(top == -1){
            throw new RuntimeException("栈为空！");
        }else{
            return data[top];
        }
    }

    public int search(int e){//返回元素在栈中位置
        int i = top;
        while(top != -1){
            if(peek() != e){
                top--;
            }else{
                break;
            }
        }
        int result = top+1;
        top = i;
        return result;

    }



}
