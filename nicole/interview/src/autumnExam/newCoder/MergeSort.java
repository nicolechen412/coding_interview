package autumnExam.newCoder;
/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2018/8/6 下午9:47
 * desc  :
 */

public class MergeSort {


    public static void main(String[] args) {
        int[] arr = new int[]{3,7,5,9,10,45,2};
        mergeSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] tmp = new int[arr.length];
        for (int i = left; i <= right; i++) {
            tmp[i] = arr[i];
        }
        int tmpLeft = left;
        int tmpRight = middle+1;
        int cur = left;
        while (tmpLeft <= middle && tmpRight <= right){
            if(tmp[tmpLeft] < tmp[tmpRight]){
                arr[cur++] = tmp[tmpLeft++];

            }else{
                arr[cur++] = tmp[tmpRight++];
            }

        }
        if(tmpLeft <= middle){
            int num = middle - tmpLeft;
            for(int i = tmpLeft; i <= middle; i++){
                arr[cur++] = tmp[i];
            }
        }

    }

}
