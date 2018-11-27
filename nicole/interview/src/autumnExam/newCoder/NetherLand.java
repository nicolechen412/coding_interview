package autumnExam.newCoder;

/**
 * @author NicoleChen
 * @date 2018/4/25 21:25
 * 通过荷兰国旗问题改进快排
 * 改进的地方:如果其中存在很多的重复数字，当选择该数字作为基准后，等于该数字的顺序已排好
 */

public class NetherLand {

    public static int[] quickSort(int[] arr, int L, int R){      //该快排算法有待考虑
        if(L < R){
            int[] p = partition(arr,L,R);
            quickSort(arr,L, p[0]-1);
            quickSort(arr, p[1]+1, R);
        }
        return arr;
    }
    public static int[] partition(int[] arr, int L, int R){
        int less = L-1;
        int more = R;
        while(L < more){    //arr[R]为基准值，less和more为替换元素的位置
            if(arr[L] < arr[R]){
                swap(arr, ++less, L++);
            }else if(arr[L] > arr[R]){
                swap(arr, L, --more);
            }else{
                L++;
            }
        }
        swap(arr, R, more);          //以数组最后一个数为比较的基准，不改变它的位置便于比较
                                    // ，直到该次基准比较结束
        return new int[]{less+1,more};
    }
    /*public static int[] NetherLand(int[] arr, int num){
        int left = -1;
        int right = arr.length;
        int index = 0;
        while(index < right){
            if(arr[index] < num){
                swap(arr,++left,index++);
            }else if(arr[index] > num){
                swap(arr,index, --right);
            }else{
                index++;
            }
        }
        return arr;
    }*/


    private static void swap(int[] arr, int i, int i1) {
        int x = arr[i];
        arr[i] = arr[i1];
        arr[i1] = x;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,7,5,0,5,7,3,2,9};
        //int[] arr = new int[]{11,76,8,3,7,5,9,10,2};

        /*int[] res = NetherLand(arr,5);
        for (int i: res) {
            System.out.print(i + " ");
        }*/
        int[] res = quickSort(arr,0,arr.length-1);
        for (int i: res) {
            System.out.print(i + " ");
        }
    }
}
