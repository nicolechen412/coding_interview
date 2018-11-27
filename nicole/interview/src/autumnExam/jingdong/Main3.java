package autumnExam.jingdong;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/9 18:55
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int num = 0;

        //int HEXvalue = 0;
        StringBuffer sb = new StringBuffer();



        if(str.length == 3){
            int[] value = new int[str.length];
            while(num < str.length){
                value[num] = Integer.parseInt(str[num]);
                num++;
            }
            if(value[0] > 255 || value[1] > 255 || value[2] > 255){
                System.out.println("error");
                return;
            }
            for (int i = 0; i < 3; i++) {

                sb.append(Integer.toHexString(value[i]));
            }
            System.out.println(sb);
        }


        if(str.length == 1){

            if(Integer.parseInt(str[0],16) > 16777215){
                System.out.println("error");
                return;
            }
            for (int i = 0; i < 6; i+=2) {
                sb.append(Integer.parseInt(str[0].substring(i,i+2),16));
                sb.append(" ");
            }
            System.out.println(sb);

        }


    }
}
