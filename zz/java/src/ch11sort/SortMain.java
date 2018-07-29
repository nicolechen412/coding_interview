package ch11sort;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/3/27 17:00
 * @desc :
 */
public class SortMain {

    public static void main(String[] args){
        int[] array = new int[]{3, 1, 4, 2, 9, 6, 7, 5};
//        insertSort(array);
//        shellSort(array);
//        bubbleSort(array);

//        quickSort(array, 0 , array.length-1);
        selectSort(array);
    }


    public static void insertSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int cur = array[i];
            if(cur < array[i-1]){
                int j;
                for(j = i; j > 0 && array[j-1] > cur; j--){
                    array[j] = array[j-1];

                }
                array[j] = cur;
            }
        }
        out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array){
        int h, i, j, cur;

        for(h = array.length / 2; h > 0; h = h/2){
            for(i = h; i < array.length; i++){
                cur = array[i];
                for (j = i; j > 0; j -= h) {
                    if(array[j-h] > cur){
                        array[j] = array[j-h];
                    }else
                        break;
                }
                array[j] = cur;
            }
        }
        out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array){
        int length = array.length;
        int tmp;
        boolean flag;
        for(int i = 0; i < array.length; i++){
            flag = false;
            for(int j = length-1; j > i; j--){
                if(array[j] < array[j-1]){
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    flag = true;
                }
            }
            if(!flag)
                break;
        }
        out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int left, int right) {
        if(left < right){
            int i = left, j = right;
            int pivot = array[left];
            while(i < j){
                while(i < j && array[j] >=pivot)
                    j--;
                if(i < j)
                    array[i++] = array[j];
                while(i < j && array[i] <= pivot)
                    i++;
                if(i < j)
                    array[j--] = array[i];
            }
            array[i] = pivot;
            quickSort(array, left, i-1);
            quickSort(array, i+1, right);
        }
        out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] array){
        int i, j;
        for(i = 0; i < array.length; i++){
            int min = i;
            for(j = i; j < array.length; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            if(i != min){
                int tmp = array[min];
                array[min] = array[i];
                array[i] = tmp;
            }
        }

        out.println(Arrays.toString(array));
    }
}
