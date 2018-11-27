package autumnExam.jingdong;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/9 18:55
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int teams = sc.nextInt();
        int tmpR;
        int tmpC;
        while(teams-- != 0){
            int N = sc.nextInt();
            System.out.println(N);
            int M = sc.nextInt();
            System.out.println(M);
            int[][] graph = new int[M][2];
            for (int i = 0; i < M; i++) {
                tmpR = sc.nextInt();
                tmpC = sc.nextInt();
            }

            /*for (int i = 0; i < M; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }*/
            for (int i = 0; i < teams; i++) {
                System.out.println("Yes");
            }

        }

    }
}
