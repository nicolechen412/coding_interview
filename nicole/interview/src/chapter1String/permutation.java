package chapter1String;

import java.util.Arrays;

/**
 * @author NicoleChen
 * @date 2018/3/7 8:40
 * 确定两个字符串，其中一个重新排列后能否变成另一个字符串
 */
public class permutation {
    //方法一
    /*public static boolean permutation(String str1,String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    public static String sort(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
        //return String.valueOf(c);//也可以转换为字符串
    }*/
    //方法二
    public static boolean permutation(String str1,String str2){
        if(str1.length() != str2.length())
            return false;
        int[] letters = new int[1000];

        char[] s_array = str1.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }
        char[] s2_array = str2.toCharArray();
        for (char c : s2_array) {
            letters[c]--;
            if(letters[c]<0)
                return false;
        }
        //另一种遍历方法，上一种应该更高效
        /*for(int i = 0; i<str1.length(); i++){
            int a = str1.charAt(i);
            letters[a]++;
        }
        for(int i = 0; i<str2.length(); i++){
            int a = str2.charAt(i);
            letters[a]--;
            if(letters[a]<0)
                return false;
        }*/
        return true;
    }

    public static void main(String[] args) {
        String str1 = "asdgfejhbv";
        String str2 = "bvhjasdfge";
        System.out.println(permutation(str1,str2));
    }
}
