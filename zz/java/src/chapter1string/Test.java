package chapter1string;

import static java.lang.System.out;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/20 10:45
 */
public class Test {
    public static void main(String[] args){
        Test test = new Test();
        String str = "aa";
//        test.isUniqueStr1_1(str);
//        test.reverse1_2(str);
//        test.replaceSpace1_4(str);
//        out.println(test.preCompress(str));
//        test.compressWord(str);
    }

//***********************************************************
    public void isUniqueStr1_1(String str){
        if(str.length() > 256) {
            out.println(false);
            return;
        }
        int[] checker = new int[256];
        int length = str.length();
        for(int i = 0; i < length; i++){
            char tmp = str.charAt(i);
            if(checker[tmp] == 0){
                checker[tmp] = 1;
            }else {
                out.println(false);
                return;
            }
        }
        out.println(true);
    }
//***********************************************************
    public void reverse1_2(String str){
        if(str == null || str.length() == 0)
            return;
        char[] strChars = str. toCharArray();
        int length = str.length();
        int mid = length / 2;
        for(int i = 0; i < mid; i++){
            char tmp = str.charAt(i);
            strChars[i] = strChars[length-i-1];
            strChars[length-i-1] = tmp;
        }
        str = new String(strChars);
        out.println(str);
    }
//***********************************************************
    public void replaceSpace1_4(String str){
        if(str == null || str.length() == 0)
            return;
        int length = str.length();
        int spaceCount = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ')
                spaceCount++;
        }
        int newLenght = length + spaceCount * 2;
        char[] newStrChars = new char[newLenght];
        newLenght--;
        for(int i = length-1; i >= 0; i--){
            char tmp = str.charAt(i);
            if(tmp != ' '){
                newStrChars[newLenght--] = tmp;
            }else{
                newStrChars[newLenght--] = '0';
                newStrChars[newLenght--] = '2';
                newStrChars[newLenght--] = '%';
            }
        }

        String newStr = new String(newStrChars);
        out.println(newStr);
    }
//***********************************************************
    public void compressWord(String str){
        if(str == null || str.length() <= 1)
            return;
        int lengthAfterComp = preCompress(str);
        if(lengthAfterComp >= str.length()) {
            out.println(str);
            return;
        }

        StringBuilder sb = new StringBuilder();
        char cur = str.charAt(0);
        int curCount = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == cur){
                curCount++;
            }else{
                sb.append(cur);
                sb.append(curCount);
                curCount = 1;
                cur = str.charAt(i);
            }
        }
        sb.append(cur);
        sb.append(curCount);
        out.println(sb.toString());
    }
    private int preCompress(String str) {

        char cur = str.charAt(0);
        int curCount = 1, totalLenght = 0;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == cur){
                curCount++;
            }else{
                totalLenght += (1+ String.valueOf(curCount).length());
                cur = str.charAt(i);
                curCount = 1;
            }
        }
        totalLenght += (1+ String.valueOf(curCount).length());
        return totalLenght;
    }
//***********************************************************
//***********************************************************


//***********************************************************

//***********************************************************

//***********************************************************

//***********************************************************
}
