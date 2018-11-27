package autumnExam.dianxin;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/14 10:14
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        int length = chars.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if(i==0 && isNumber(chars[i])){
                sb.append("*");
                sb.append(chars[0]);
                if(i< chars.length-1 &&(!isNumber(chars[i+1]))){
                    sb.append("*");
                }
            }else if(isNumber(chars[i])){
                if(!isNumber(chars[i-1])){
                    sb.append("*");
                }
                sb.append(chars[i]);
                if(i< chars.length-1 &&(!isNumber(chars[i+1]))){
                    sb.append("*");
                }

            }else{
                sb.append(chars[i]);
            }
            if(i == chars.length-1 && isNumber(chars[i])){
                sb.append("*");
            }
        }
        System.out.println(sb);

    }
    public static boolean isNumber(char c){
        if(c >= '0' && c <= '9')
            return true;
        else
            return false;
    }
}
