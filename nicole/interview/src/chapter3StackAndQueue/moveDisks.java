package chapter3StackAndQueue;



/**
 * @author NicoleChen
 * @date 2018/3/16 9:03
 */
public class moveDisks {
    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[n];
        for(int i = 0; i<3; i++){
            towers[i] = new Tower(i);
        }
        for(int j = n; j>0; j--){
            towers[0].add(j);
        }
        towers[0].moveDisks(n,towers[2],towers[1]);

    }

}


 class Tower{
    public Stack<Integer> disks;
    int index;
    public Tower(int d){
        disks = new Stack<>();
        index = d;
    }

    public void add(int d){
        if(!disks.isEmpty() && disks.peek() <= d){
            System.out.println("Error placing disk" + d);
        }else{
            disks.push(d);
        }
    }
    public void moveTop(Tower t){
        int top = disks.pop();
        t.add(top);
        System.out.println("Move disk " + top + " from " + index + " to " + t.index);
    }

    public void moveDisks(int n, Tower destination, Tower buffer){
        if(n > 0){
            moveDisks(n-1, buffer, destination);
            moveTop(destination);
            buffer.moveDisks(n-1,destination,this);
        }

    }
}
