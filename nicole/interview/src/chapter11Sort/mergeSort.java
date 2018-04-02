package chapter11Sort;

/**
 * @author NicoleChen
 * @date 2018/4/2 10:13
 */
public class mergeSort {
    public static void mergeSort(int[] arr,int left,int right){
       if(left<right){
           int middle = (left+right)/2;
           mergeSort(arr,left,middle);
           mergeSort(arr,middle+1,right);
           merge(arr,left,middle,right);
       }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] helper = new int[arr.length];
        for(int i = left; i<=right; i++){
            helper[i] = arr[i];
        }
        int helperLeft = left;
        int helperRight = middle+1;
        int cur = left;
        while(helperLeft<=middle && helperRight <= right){
            if(helper[helperLeft] <= helper[helperRight]){
                arr[cur] = helper[helperLeft];
                helperLeft++;
            }else{
                arr[cur] = helper[helperRight];
                helperRight++;
            }
            cur++;
        }
        int rem = middle - helperLeft;//差值为n，但要填n+1个元素，因为helperLeft指的位置还没元素。
        for(int i = 0; i<=rem; i++){ //注意i和rem的等号问题
            arr[cur++] = helper[helperLeft++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,9,78,9,23,4,6,0};

        mergeSort(arr,0,arr.length-1);
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
