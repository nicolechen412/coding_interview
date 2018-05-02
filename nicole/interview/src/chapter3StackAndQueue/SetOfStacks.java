package chapter3StackAndQueue;

import java.util.ArrayList;

/**
 * @author NicoleChen
 * @date 2018/3/15 8:30
 */
public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<>();
    Stack last;
    int size;

    public void push(int item){
        last = getLastStack();
        if(!last.isEmpty() && !last.isfull()){
            last.push(item);
        }else{
            Stack a = new Stack();
            a.push(item);
            stacks.add(a);
        }
    }
    public int pop(){
        last = getLastStack();
        int item = last.pop();
        if (last.isEmpty()){
            stacks.remove(stacks.size()-1);
        }
        return item;
    }

    public Stack getLastStack(){
        if(stacks != null){
            return stacks.get(stacks.size()-1);
        }else{
            return null;
        }
    }
}
