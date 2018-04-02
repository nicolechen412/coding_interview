package chapter11Sort;

/**
 * @author NicoleChen
 * @date 2018/4/2 11:04
 */
public class quickSort {
    public static void quickSort(int[] arr, int left, int right){
        int index = partition(arr,left,right);
        if(left<index-1){
            quickSort(arr,left,index-1);
        }
        if(right>index){
            quickSort(arr,index,right);
        }

    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right)/2];
        while (left<right){ //注意等号问题
            while(arr[left]<pivot)left++;
            while(arr[right]>pivot)right--;
            if(left<=right){//注意等号问题
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int a = arr[left];
        arr[left] = arr[right];
        arr[right] = a;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{56,76,4,87,4,3,1};
        quickSort(arr,0,arr.length-1);
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
