package autumnExam.tencent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/16 9:54
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int teams = sc.nextInt();
        int A =0 , B = 0, C = 0, choice;
        ArrayList<Integer> array = new ArrayList<>();
        boolean flag = false;
        while (teams > 0){

                A = sc.nextInt();
                B = sc.nextInt();
                C = sc.nextInt();
                for (int j = 0; j < 100; j++) {
                    flag = false;
                    if((B*j + C) % A == 0 ){
                        flag = true;
                        break;
                    }
                }


                //array = getChoice(A, B, C);
               /* for (int j = 0; j < array.size(); j++) {
                    if(array.get(j) % B == C){
                        System.out.println("YES");
                    }
                    break;
                }
                System.out.println("NO");*/
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            teams--;
        }


        }
    }
    /*static ArrayList<Integer> getChoice(int A, int B, int C){
        ArrayList<Integer> array = new ArrayList<>();
        array.add(A);
        *//*if(B % A == 0 && C % A == 0) {
            array.add(B);
            array.add(A+B);
            array.add(A+C);
            array.add(B+C);
            array.add(A+B+C);
        }else if(C % A == 0) {
            array.add(C);
            array.add(A+C);
        }else if(B % A == 0){
            array.add(B);
            array.add(A+B);
        }*//*
        if(B % A == 0) {
            array.add(B);
            array.add(A+B);
        }
        if(C % A == 0) {
            array.add(C);
            array.add(A+C);
        }
        if((B+C) % A == 0) {
            array.add(B+C);
            array.add(A+B+C);
        }


        return array;
    }*/

