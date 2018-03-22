package chapter1String;

/**
 * @author NicoleChen
 * @date 2018/3/8 9:13
 */
public class compressBetter {
    public static String compressBetter(String str){
        //先判断可以省略后面的字符串拼接操作
        if (countCompression(str) >= str.length()){
            return str;
        }
        StringBuffer sb = new StringBuffer();
        //不使用StringBuffer可以使用字符数组
        int count = 1;
        char last = str.charAt(0);
        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }else {
                sb.append(last);
                sb.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        sb.append(last);
        sb.append(count);
        /*if(sb.length() < str.length()){
            return sb.toString();
        }
        return str;*/
        return sb.toString();
    }
    public static int countCompression(String str){
        if(str == null || str.isEmpty()) return 0;
        int count = 1;
        int size=0;
        char last = str.charAt(0);
        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }else {
                last = str.charAt(i);
                size += String.valueOf(count).length()+1;
                count = 1;

            }
        }
        size += String.valueOf(count).length()+1;
        return size;
    }
    public static void main(String[] args){
        String str = "aabbccddff";
        System.out.println(compressBetter(str));
    }

}
