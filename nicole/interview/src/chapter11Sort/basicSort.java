package chapter11Sort;

/**
 * @author NicoleChen
 * @date 2018/3/30 8:46
 */
public class basicSort {
    //冒泡排序
    public static void bubbleSort(int[] arr){
        boolean flag = false;

        int count = arr.length;
        while(count>0){
        //while (!flag){
            for(int i = 0; i<arr.length-1; i++){
                if(arr[i]>arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
            count--;
          /*  for (int j = 0; j < arr.length-1; j++) {
                if(arr[j] > arr[j+1]){
                    flag = false;
                    break;
                }
                flag = true;
            }*/
        }

    }
    //选择排序
    public static void selectSort(int[] arr) {

        for(int j = 0; j<arr.length-1; j++){
            int min = arr[j];
            int loc = 0;
            for (int i = j+1; i < arr.length; i++) {
                if(arr[i]< min){
                    min = arr[i];
                    loc = i;
                }
            }
            //System.out.println(loc+" "+ j+" ");
            //System.out.println(min + " "+arr[loc] + " " + arr[j]);
            arr[loc] = arr[j];
            arr[j] = min;
            //System.out.println(arr[loc] + " " + arr[j]);
        }

        //System.out.println(min);
    }
    //归并排序
    public static void mergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low < high){
            int middle = (low+high)/2;
            mergeSort(arr,low,middle);
            mergeSort(arr,middle+1,high);
            merge(arr,low,middle,high);
        }
    }

    private static void merge(int[] arr, int low, int middle, int high) {
        int[] helper = new int[arr.length];
        for(int i =low;i<=high; i++){
            helper[i] = arr[i];
        }
        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;
        while(helperLeft<=middle && helperRight<=high){
            if(helper[helperLeft] <= helper[helperRight]){
                arr[current] = helper[helperLeft];
                helperLeft++;
            }else{
                arr[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        int remaining = middle - helperLeft;
        for(int i = 0; i<=remaining; i++){
            arr[current+i] = helper[helperLeft+i];
        }
    }
    //快速排序
    private static void quickSort(int[] arr,int left,int right) {

        int index = partition(arr,left,right);
        if(left<index-1){
            quickSort(arr,left,index-1);
        }
        if(index < right){
            quickSort(arr,index,right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right)/2];
        while(left <= right){
            while(arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if(left<= right){
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
        //int[] arr = new int[]{4,7,2,9,12,15,17,13};
        int[] arr = new int[]{12,15,17,13,4,7,2,9,};
        //bubbleSort(arr);
        //selectSort(arr);
        mergeSort(arr);
        //quickSort(arr,0,arr.length-1);
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


}
