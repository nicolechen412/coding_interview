package ch3stackqueue;

import static java.lang.System.out;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/22 19:41
 */
public class ThreeStack3_1 {
    public static final int STACK_LENGTH = 30;
    public static int[] arr = new int[STACK_LENGTH];
    public static final int firstTop = 9;
    public static final int secondTop = 19;
    public static final int thirdTop = 29;

    public static int cur1 = -1, cur2 = 9, cur3 = 19;

    public static void main(String[] args){
        push1(1);
        push1(2);
        push1(3);
        push2(11);
        push2(12);
        push3(21);
        out.println(pop2());
        out.println(pop1());
        out.println(pop3());
        out.println(pop3());
    }

    public static void push1(int value){
        if(cur1 == firstTop){
            out.println("Stack full");
            return;
        }
        arr[++cur1] = value;
    }
    public static void push2(int value){
        if(cur2 == secondTop){
            out.println("Stack full");
            return;
        }
        arr[++cur2] = value;
    }
    public static void push3(int value){
        if(cur3 == thirdTop){
            out.println("Stack full");
            return;
        }
        arr[++cur3] = value;
    }

    public static int pop1(){
        if(cur1 < 0){
            out.println("Empty stack");
            return -1;
        }
        return arr[cur1--];
    }
    public static int pop2(){
        if(cur2 < 10){
            out.println("Empty stack");
            return -1;
        }
        return arr[cur2--];
    }
    public static int pop3(){
        if(cur3 < 20){
            out.println("Empty stack");
            return -1;
        }
        return arr[cur3--];
    }
}
