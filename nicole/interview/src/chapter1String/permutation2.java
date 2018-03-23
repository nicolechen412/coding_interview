package chapter1String;

import java.util.Arrays;

/**
 * @author NicoleChen
 * @date 2018/3/20 11:05
 * 全排列问题
 */
public class permutation2 {
    public static void main(String[] args) {
        String s = "123";
        permutation2(s);
    }

    public static void permutation2(String s){
        char[] c = s.toCharArray();
        int len = c.length;
        allWord(c,0);

    }

    public static void allWord(char[] chars, int start){
        if(start == chars.length-1){
            System.out.println(Arrays.toString(chars));
        }
        else{
            for(int i = start; i<chars.length; i++){
                //if(!isSwap(chars,start,i)){
                    swap(chars,start,i);
                    allWord(chars, start+1);
                    swap(chars,start,i);
                //}
            }
        }
    }

    private static boolean isSwap(char[] chars, int start, int end) {
        for(int j = start; j<end; j++){
            if(chars[j] == chars[end]){
                return true;
            }
        }
        return false;

    }

    private static void swap(char[] chars, int start, int i) {
        char temp = chars[start];
        chars[start] = chars[i];
        chars[i] = temp;
    }


}
