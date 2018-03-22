package chapter1String;

/**
 * @author NicoleChen
 * @date 2018/3/7 9:52
 */
public class replaceSpace {
    public static char[] replaceSpace(char[] s_array,int length){
        int spaceCount=0;
        for(int i = 0; i<length; i++){
            if(s_array[i] == ' '){
                spaceCount++;
            }
        }
        int newLength = length+spaceCount*2;
        for(int i = length-1; i>=0; i--){
            if(s_array[i] == ' '){
                s_array[newLength-3] = '%';
                s_array[newLength-2] = '2';
                s_array[newLength-1] = '0';
                newLength -=3;
            }else {
                s_array[newLength-1] = s_array[i];
                newLength -=1;
            }
        }
        return s_array;
    }
    public static void main(String[] args) {
        //String str="asdfghjkl";
        char[] s_array = new char[100];
//        System.out.println(s_array.length);
//        System.out.println(s_array);
        s_array[0] = 'a';
        s_array[1] = 'b';
        s_array[2] = 'c';
        s_array[3] = 'd';
        s_array[4] = ' ';
        s_array[5] = 'e';
        s_array[6] = 'd';
        s_array[7] = ' ';
        s_array[8] = 'e';
//        System.out.println(s_array.length);
//        System.out.println(s_array);
        System.out.println(replaceSpace(s_array,9));
    }
}
