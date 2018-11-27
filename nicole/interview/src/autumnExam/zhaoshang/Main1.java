package autumnExam.zhaoshang;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/8/30 18:48
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String str = null;
        //str = sc.nextLine();
        while(sc.hasNext()){
       // while(str.length() != 0){

            char[] num = sc.nextLine().toCharArray();
            int count1 = 0;
            int count2 = 0;
            char less ;
            int moreCount = 0;
            for (int i = 0; i < num.length; i++) {
                if(num[i] == 'C') moreCount++;
            }
            if (moreCount >= (num.length / 2)) {
                less = 'D';
            }
            else {
                less = 'C';
            }
            int sum1 = 0;
            for (int i = 0; i < num.length; i++) {
                if(num[i] == less){

                    sum1 += (i-count1);
                    count1++;
                    //System.out.println("sum1:" + sum1);
                }

            }
            int sum2 = 0;
            for (int i = num.length-1; i > 0; i--) {
                if(num[i] == less){

                    sum2 += num.length-1-count2-i;
                    //System.out.println("sum2:" + sum2);
                    count2++;
                }
            }

            System.out.println(Math.min(sum1,sum2));
            //str = sc.nextLine().trim();
        }

    }

    private static void swap(String[] num, int first, int last) {
        String tmp = num[first];
        num[first] = num[last];
        num[last] = tmp;
    }
}
