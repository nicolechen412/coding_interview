package ch3stackqueue;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/23 10:18
 */
public class QueueTwoStack3_5 {
    public static LinkStack stack1 = new LinkStack();
    public static LinkStack stack2 = new LinkStack();

    public static void enque(int value){
        stack1.push(value);
    }
    public static int deque(){
        int value = -1;
        if(stack1.isEmpty() && stack2.isEmpty()){ //都是空的
            System.out.print("Empty Queue : ");
            return value;
        }else if(!stack2.isEmpty()){ //stack2非空，直接可以输出
            value = stack2.pop();
        }else if(stack2.isEmpty() && !stack1.isEmpty()){ //新push到stack1的，
            while(!stack1.isEmpty()){
                value = stack1.pop();
                stack2.push(value);
            }
            value = stack2.pop();
        }
        return value;
    }
    public static void main(String[] args){
        enque(1);
        enque(1);
        System.out.println(deque());
        System.out.println(deque());
        enque(2);
        System.out.println(deque());
        System.out.println(deque());
        enque(2);
        enque(2);
        System.out.println(deque());
        System.out.println(deque());
        System.out.println(deque());
    }

}
