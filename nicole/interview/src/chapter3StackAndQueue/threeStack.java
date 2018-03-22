package chapter3StackAndQueue;

/**
 * @author NicoleChen
 * @date 2018/3/14 8:32
 */
public class threeStack {
    int size = 100;
    int stackNumber;
    int[] data = new int[size*3];
    int[] top  = new int[]{-1,-1,-1};

    public int pop(int stackNumber){
        if(top[stackNumber] == -1){
            throw new RuntimeException("栈为空");
        }else{
            top[stackNumber]--;
            return data[absTopOfStack(stackNumber)];
        }

    }
    public boolean push(int item, int stackNumber) throws Exception {
        if(top[stackNumber]+1 == size){
            throw new Exception("栈已满");
        }else{
            top[stackNumber]++;
            data[absTopOfStack(stackNumber)] = item;
            return true;
        }
    }
    public int peek(int stackNumer){
        if(top[stackNumber] == -1){
            throw new RuntimeException("栈为空");
        }else{
            return data[absTopOfStack(stackNumber)];
        }

    }
    public int absTopOfStack(int stackNumber){
        return stackNumber*size + top[stackNumber];
    }
}
