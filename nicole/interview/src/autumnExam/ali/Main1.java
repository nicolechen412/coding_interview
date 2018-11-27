package autumnExam.ali;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/7 14:50
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String line = scanner.nextLine();
        char[] chars = scanner.nextLine().toCharArray();

        int maxIndex = 0, maxLen = 0;
       // int index = 0,
        int len = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            if(set.isEmpty()){
                set.add(curChar);
               // index = i;
                len++;
            }else{ //set not null
                if(set.contains(curChar)){ //set 包含char
                    set.clear();
                    set.add(curChar);
                    if(len > maxLen){
                        maxLen = len;
                        maxIndex = i;
                    }
                    len = 1;
                    //index = i;
                }else{ //当前set不含有
                    set.add(curChar);
                    len++;
                }
            }
        }
//        System.out.println(maxIndex-maxLen + " " + maxLen);
        int start = maxIndex-maxLen;
        int end = start + maxLen;
        if(end == 0){
//            end = line.length();
            System.out.println(chars.length);
        }else{
            System.out.println(maxLen);
        }
        /*System.out.println(start + " " + end);
        String substring = line.substring(start, end);
        System.out.println(substring);*/
        return;
    }
}
