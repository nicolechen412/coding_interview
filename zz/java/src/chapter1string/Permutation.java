package chapter1string;

import java.util.Arrays;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/20 10:45
 */
public class Permutation {
    public static void main(String[] args){
        int[] numbers = new int[]{1,2,3};
        permutation(numbers, 0, numbers.length);
    }

    private static void permutation(int[] numbers, int i, int length) {
        if(i == length-1){
            System.out.println(Arrays.toString(numbers));
        }

        int tmp;
        for(int j = i; j < length; j++){
            tmp = numbers[i]; numbers[i] = numbers[j]; numbers[j] = tmp;
            permutation(numbers, i+1, length);
            tmp = numbers[i]; numbers[i] = numbers[j]; numbers[j] = tmp;
        }
    }
}
