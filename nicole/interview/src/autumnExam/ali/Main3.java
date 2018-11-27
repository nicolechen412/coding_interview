package autumnExam.ali;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/7 14:51
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] noSign = sc.nextLine().toCharArray();
        /*for (int i = 0; i < noSign.length; i++) {
            System.out.println(noSign[i]);
        }*/
        int count = 0;
        int remainder = 0;
        if(noSign.length == 4 && noSign[0] != 0){
            System.out.println(1);
        }else if(noSign.length > 12){
            System.out.println(0);
        }else if(noSign.length == 12){
            for (int i = 0; i < 12; i=i+3) {
                if(noSign[i] > '2'){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }

            }
        }else{
            remainder = noSign.length % 4;
            for (int i = remainder; i > 0; i--) {
                count += comb(4,i);
            }
            //count = comb(4, remainder) + 4;
        }
        System.out.println(count);

    }

    private static int comb(int n, int remainder) {
        if(remainder > n) return 0;
        if(remainder == 0) return 1;
        return comb(n-1, remainder-1) + comb(n-1, remainder);
    }
}
