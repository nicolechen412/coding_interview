package chapter3StackAndQueue;

/**
 * @author NicoleChen
 * @date 2018/3/14 9:17
 */
public class StackWithMin extends Stack<Number> {
    Stack<Number> s2;
    public void StackWithMin(){
        s2 = new Stack<Number>();
    }

    public int pop(){
        int value = super.pop();
        if(value == min()){
            s2.pop();
        }
        return value;
    }

    public void push(int item){
        super.push(item);
        if(item <= min()){
            s2.push(item);
        }
    }

    public int min(){
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
         return s2.peek();
        }
    }
}
