package autumnExam.ebay;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/25 18:59
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] poke = new int[3][3];
        int count = 0;
        int min = Integer.MAX_VALUE;
        int step = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                poke[i][j] = sc.nextInt();
                if(poke[i][j] == 0) count++;
            }
        }
        overturn(poke, count, step, min);
        System.out.println(min);

        /*for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(poke[i][j]);
            }
        }*/
    }

    private static int overturn(int[][] poke, int count, int step, int min) {
        if(count == 0){
            if(step < min)
                min = step;
            return min;
        }
        step++;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(poke[i][j] == 0){
                    poke[i][j] = 1;
                    if(i-1 >= 0)
                        poke[i-1][j] = poke[i-1][j]==1 ? 0 : 1;
                    if(j-1 >= 0)
                        poke[i][j-1] = poke[i][j-1]==1 ? 0 : 1;
                    if(i+1 < 3)
                        poke[i+1][j] = poke[i+1][j]==1 ? 0 : 1;
                    if(j+1 < 3)
                        poke[i][j+1] = poke[i][j+1]==1 ? 0 : 1;
                }
            }
        }
        if(count != 0)
            overturn(poke, count, step, min);
        return min;

    }
}
