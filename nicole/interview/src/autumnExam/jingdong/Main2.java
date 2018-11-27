package autumnExam.jingdong;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/9 18:55
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int count = 0;
        int[][] num = new int[col][3];
        boolean[] flag = new boolean[col];
        for (int i = 0; i < col; i++) {
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
            num[i][2] = sc.nextInt();
        }

        for (int i = 1; i < col; i++) {

            for (int j = 0; j < i; j++) {
                /*if(flag[j]){
                    continue;
                }*/
                if(num[i][0]>num[j][0] && num[i][1]>num[j][1] && num[i][2]>num[j][2]){
                    //flag[j] = true;
                    count++;
                }
                if(num[i][0]<num[j][0] && num[i][1]<num[j][1] && num[i][2]<num[j][2]){
                    //flag[i] = true;
                    count++;
                    //break;
                }
            }
        }
        System.out.println(count);
    }
}
