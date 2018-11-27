package autumnExam.iqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/15 9:55
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        int[] num1 = new int[3];
        int[] num2 = new int[3];
        for (int i = 0; i < 3; i++) {
            num1[i] = chars[i] - '0';
        }
        int j = 0;
        for (int i = 3; i < 6; i++) {
            num2[j] = chars[i] - '0';
            j++;
        }
        int preNum = 0;
        int nextNum = 0;
        for (int i = 0; i < 3; i++) {
            preNum += num1[i];
        }
        for (int i = 0; i < 3; i++) {
            nextNum += num2[i];
        }
        System.out.println(preNum + " " + nextNum);
        int count1 = 0;
        int count2 = 0;
        int needs = nextNum - preNum;
        Arrays.sort(num1);
        Arrays.sort(num2);
        if(needs > 0){    //nextNum大
            for (int i = 0; i < 3; i++) {
                count1++;
                if(needs + num1[i] <= 9){
                    break;
                }else{
                    needs -= (9 - num1[i]);
                }
            }
            needs = nextNum - preNum;
            for (int i = 0; i < 3; i++) {
                count2++;
                if(num2[i] - needs >= 0){
                    break;
                }else{
                    needs -= num2[i];
                }
            }
            System.out.println(count1 < count2 ? count1 : count2);
        }else if(needs < 0){   //preNum大
            needs = Math.abs(needs);
            for (int i = 0; i < 3; i++) {
                count1++;
                if(needs + num2[i] <= 9){
                    break;
                }else{
                    needs -= (9 - num2[i]);
                }
            }
            needs = Math.abs(nextNum - preNum);
            for (int i = 0; i < 3; i++) {
                count2++;
                if(num1[i] - needs >= 0){
                    break;
                }else{
                    needs -= num1[i];
                }
            }
            System.out.println(count1 < count2 ? count1 : count2);
        }else {
            System.out.println(0);
        }

    }
}
