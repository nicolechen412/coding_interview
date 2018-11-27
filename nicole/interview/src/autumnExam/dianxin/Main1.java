package autumnExam.dianxin;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/14 10:11
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean[] isLucky = new boolean[num];
        for (int i = 0; i < num; i++) {
            isLucky[i] = true;
        }
        //System.out.println(isLucky[0]);
        int leftNum = num;
        int count = 1;
        while(leftNum != 1){
            for(int i = 0; i < num; i++) {
                if(isLucky[i] && count != 3){
                    count++;
                }else if(!isLucky[i]){
                    continue;
                }else{
                    isLucky[i] = false;
                    leftNum--;
                    count=1;
                }
            }
        }
        for (int i = 0; i < isLucky.length; i++) {
            if(isLucky[i]){
                System.out.println(i+1);
            }
        }




       /* Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[] arr = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;//下标为TRUE时说明还在圈里
        }
        int leftCount = n;
        int countNum = 0;
        int index = 0;
        while (leftCount > 1) {
            if (arr[index] == true) {//当在圈里时
                countNum++; //报数递加
                if (countNum == 3) {//报道3时
                    countNum = 0;//从零开始继续报数
                    arr[index] = false;//此人退出圈子
                    leftCount--;//剩余人数减一
                }
            }
            index++;//每报一次数，下标加一
            if (index == n) {//是循环数数，当下标大于n时，说明已经数了一圈，
                index = 0;//将下标设为零重新开始。
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == true) {
                System.out.println(i);
            }
        }*/
    }
}



/*
import java.util.Scanner;
public class Ex37 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[] arr = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;//下标为TRUE时说明还在圈里
        }
        int leftCount = n;
        int countNum = 0;
        int index = 0;
        while (leftCount > 1) {
            if (arr[index] == true) {//当在圈里时
                countNum++; //报数递加
                if (countNum == 3) {//报道3时
                    countNum = 0;//从零开始继续报数
                    arr[index] = false;//此人退出圈子
                    leftCount--;//剩余人数减一
                }
            }
            index++;//每报一次数，下标加一
            if (index == n) {//是循环数数，当下标大于n时，说明已经数了一圈，
                index = 0;//将下标设为零重新开始。
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == true) {
                System.out.println(i);
            }
        }
    }
}*/
