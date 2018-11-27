package autumnExam.ali;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/7 14:51
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        byte[][] matrx = new byte[num][num];
        //boolean[][] judge = new boolean[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrx[i][j] = sc.nextByte();
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(matrx[i][j] == 1){
                    count++;
                    calcul(matrx, i, j);

                }
            }
        }
        System.out.println(count);
    }

    private static void calcul(byte[][] matrx, int i, int j) {
        matrx[i][j] = 0;
        if(j > 0 && matrx[i][j-1] == 1){
            calcul(matrx, i, j-1);
        }
        if(i > 0 && matrx[i-1][j] == 1){
            calcul(matrx, i-1, j);
        }
        if(j < matrx.length-1 &&matrx[i][j+1] == 1){
            calcul(matrx, i, j+1);
        }
        if(i <matrx.length-1 &&matrx[i+1][j] == 1){
            calcul(matrx, i+1, j);
        }
    }
}
