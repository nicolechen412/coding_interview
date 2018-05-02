package newCoder;

/**
 * @author NicoleChen
 * @date 2018/4/26 21:37
 */
public class heapSort {
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i<arr.length; i++){
            heapInsert(arr, i);
        }
        for(int x: arr){
            System.out.print(x + " ");
        }
        System.out.println();
        int size = arr.length;

        arr[0] = 1;
        /*for(int x: arr){
            System.out.print(x + " ");
        }
        System.out.println();*/

        //while (size > 0){
            heapify(arr, 0, size);

            //swap(arr,0,--size);

       // }
        for(int x: arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        /*int left = index*2+1;
        int right = left+1;
        while (left < heapSize){
            int max = (left+1 < heapSize && arr[left] > arr[right]) ? left : right;
            System.out.println("max:" + max + " index:" + index + " left:" + left);
            if(arr[index] >= arr[max]){
                break;
            }else{
                swap(arr, index, max);
                index = max;
                left = index*2 + 1;
                System.out.println("2222max:" + max + " index:" + index + " left:" + left);
            }
            for(int x : arr){
                System.out.print(x + " ");
            }
            System.out.println();

        }*/
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void swap(int[] arr, int index, int i) {
        int x = arr[index];
        arr[index] = arr[i];
        arr[i] = x;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,5,6,2,4,3};
        heapSort(arr);
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
