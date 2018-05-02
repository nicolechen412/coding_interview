package chapter11Sort;

/**
 * @author NicoleChen
 * @date 2018/4/2 11:34
 */
public class binarySearch {
    public static int binarySearch(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int mid;
        while (low<high){
            mid = (low+high)/2;
            if(arr[mid]>x){
                high = mid-1;
            }else if(arr[mid] <x){
                low = mid+1;
            }else{
                System.out.println(mid);
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int low, int high, int x){
        if(low>high){
            System.out.println(-1);
            return -1;
        }
        int mid = (low+high)/2;
        if(arr[mid] == x){
            System.out.println(mid);
            return mid;
        }else if(arr[mid]>x){
            return binarySearchRecursive(arr,low,mid-1,x);
        }else {
            return binarySearchRecursive(arr,mid+1,high,x);
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,4,7,9,12,34,37};
        int x = 12;
        //binarySearch(arr,x);
        binarySearchRecursive(arr,0,arr.length-1,x);
    }
}
