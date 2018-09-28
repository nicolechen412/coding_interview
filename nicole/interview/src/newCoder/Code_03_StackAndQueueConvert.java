package newCoder;

import javax.naming.InsufficientResourcesException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author NicoleChen
 * @date 2018/5/14 10:18
 */
public class Code_03_StackAndQueueConvert {
    public static class TwoStackQueue{
        Stack<Integer> s1 ;
        Stack<Integer> s2 ;

        public TwoStackQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int num){
            s1.push(num);
        }
        public int poll(){
            if(s1.isEmpty() && s2.isEmpty()){
                throw new RuntimeException("Queue is empty");
            }else if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
        public int peek(){
            if(s1.isEmpty() && s2.isEmpty()){
                throw new RuntimeException("Queue is Empty");
            }else if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();

        }
    }
    public static class TwoQueueStack{
        Queue<Integer> q1;
        Queue<Integer> q2;
        public TwoQueueStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        public void push(int num){
            q1.add(num);
        }
        public int pop(){
            if(q1.isEmpty()){
                throw new RuntimeException("Stack is Empty");
            }else{
                while (q1.size()>1){
                    q2.add(q1.poll());
                }
            }
            int res = q1.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> q3 = q1;
            q1 = q2;
            q2 = q3;
        }

        public int peek(){
            if(q1.isEmpty()){
                throw new RuntimeException("Stack is Empty");
            }else{
                while(q1.size()>1){
                    q2.add(q1.poll());
                }
            }
            int res = q1.poll();
            q2.add(res);
            swap();
            return res;
        }
    }

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();
        stack.push(3);
        stack.push(6);
        stack.push(7);
        stack.push(9);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

    }
}
