package chapter1String;

/**
 * @author NicoleChen
 * @date 2018/3/6 8:53
 * 不使用额外的数据结构，如何确定一个字符串中的所有字符是否全都不同
 * 该字符串是ASCII字符串
 */
public class isUniqueChars {
    /*public static boolean isUniqueChars(String str){
        if(str.length()>256) return false;
        boolean[] char_set = new boolean[256];
        for(int i = 0; i<str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }*/
    //假定字母只有a到z，使用位运算
    public static boolean isUniqueChars(String str){
        if(str.length()>26) return false;
        int checker = 0;
        /*for(int i = 0; i<str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1<<val);
        }*/
        char[] c_str = str.toCharArray();
        for (char c : c_str) {
            int val = c-'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1<<val);
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "ergASDhhgh";
        System.out.println(isUniqueChars(str));
    }
}
