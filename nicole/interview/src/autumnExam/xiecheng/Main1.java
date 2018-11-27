package autumnExam.xiecheng;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/4 18:25
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();
        char[] binary = Long.toBinaryString(num).toCharArray();
        //System.out.println(num);
        int countOne = 0;


        /*int i = 0;
        int length = binary.length-1;
        while(i <= length){
            if(binary[i]=='1'){
                countOne++;
            }
            i++;
        }*/

        int res = 0;
        for(int i = 0; i < binary.length; i++){
            if(binary[i] == '1')
                res++;
        }
        System.out.println(res);

//        System.out.println(countOne);
    }
}
