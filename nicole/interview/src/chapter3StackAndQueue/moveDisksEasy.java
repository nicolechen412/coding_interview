package chapter3StackAndQueue;

/**
 * @author NicoleChen
 * @date 2018/3/18 16:45
 */
public class moveDisksEasy {
    public static void main(String[] args) {
        int n = 3;
        moveDisks(n,1,3,2);
    }

    public static void moveDisks(int n, int s,int d, int b){
        if(n == 1){
            System.out.println("move " + n +" from " +s +" to " + d);
        }else{
            moveDisks(n-1,s,b,d);
            System.out.println("move " + n +" from " +s +" to " + d);
            moveDisks(n-1,b,d,s);
        }

    }
}
