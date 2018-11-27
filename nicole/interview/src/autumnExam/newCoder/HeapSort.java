package autumnExam.newCoder;

/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2018/8/10 上午11:18
 * desc  :
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{11,76,8,3,7,5,9,10,2};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int size = arr.length;
        while(size > 0) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void heapify(int[] arr, int index, int size) {

        int left = index  * 2  + 1;  //乘法和加法的顺序要注意
        while(left < size){
            int largeIndex = (left+1 < size && arr[left+1] > arr[left]) ? left+1 : left;
            largeIndex = arr[largeIndex] > arr[index] ? largeIndex : index;
            if(largeIndex == index)
                break;
            swap(arr, largeIndex, index);
            index = largeIndex;
            left = index * 2 + 1;

        }


    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);  //index必须减1才能找到他的父节点，否则是父节点的兄弟节点。
            index = (index-1)/2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
