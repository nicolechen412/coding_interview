package autumnExam.newCoder;
/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2018/8/7 下午9:38
 * desc  :
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{11,76,8,3,7,5,9,10,2};//这个数组检查问题
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end || arr == null || arr.length<=1)
            return;
        int tmp = arr[start];
        int i = start;
        int j = end;
        while(i <= j){       //一定要有等于的情况
            while(arr[i] < tmp) i++;
            while(arr[j] > tmp) j--;
            //一定要处理i==j的情况，否则会造成死循环
            //也可以写成
            if(i<=j){
              swap(arr,i++, j--);
             }
//            if(i < j) {
//                swap(arr, i++, j--);
//            }else if(i == j){
//               ++i;
           // }
        }
       // if(start < j)         //判断条件可以加在函数进入的地方
            quickSort(arr, start, j);  //需要注意，例如8，5，7三个数排序，以8为基准，交换后为7，5，8，i：1，j：1。分别比较7和5，8，检查不出问题。
                                        //这里有两个做法，1。while循环一定要加==的情况。2。这里的递归end为j
       // if(i < end)
            quickSort(arr, i, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
