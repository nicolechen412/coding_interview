package autumnExam.toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/8/12 10:01
 *
 * 第二题
 */
public class dance1 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int editor = Integer.valueOf(sc.nextLine());
        String[] workEditor = new String[editor];
        for (int i = 0; i < editor; i++) {
            workEditor[i] = sc.nextLine();
        }
        *//*for (int i = 0; i < editor; i++) {
            System.out.println(workEditor[i]);
            System.out.println();
        }*//*
        int allLength = 0;
        for (int i = 0; i < editor; i++) {
            allLength += workEditor[i].split(";").length;
        }
        //LinkedList<String> list = new LinkedList<>();
        String[] allStr = new String[allLength];
        int tmp = 0;
        while(tmp < allLength) {
            for (int k = 0; k < editor; k++) {
                int size = workEditor[k].split(";").length;
                String[] str = workEditor[k].split(";");
                for (int j = 0; j < size; j++) {
                    allStr[tmp++] = str[j];
                }
            }
        }
        Arrays.sort(allStr);
        for (int i = 0; i < allStr.length-1; i++) {
            //int[] num = Integer.parseInt(allStr[i].split(","));
            int[] num2 = new int[2];
           // if()
        }
        *//*for (int i = 0; i < allStr.length; i++) {
            System.out.println(allStr[i]);
        }*//*


    }*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line ;
        line = scanner.nextLine();
        String[] msg = line.split(",");
        int m = Integer.parseInt(msg[0]);
        int n = Integer.parseInt(msg[1]);
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            line = scanner.nextLine();
            msg = line.split(",");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(msg[j]);
            }
        }
        count(arr);

    }


    public static int count(int[][] arr) {
        if (arr == null || arr[0] == null) {
            return 0;
        }
        int row = arr.length;
        int column = arr[0].length;
        int res = 0;
        ArrayList<Integer> valueList = new ArrayList<>();
        valueList.add(0);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] == 1) {
                    res++;
                    valueList.set(0, 0);
                    check(arr, i, j, row, column, valueList);
                    list.add(valueList.get(0));
                }
            }
        }
        Collections.sort(list);
        System.out.println(res + "," + list.get(list.size()-1));
        return res;
    }

    public static void check(int[][] m, int i, int j, int row, int column, ArrayList<Integer> value) {
        if (i < 0 || i >= row || j < 0 || j >= column || m[i][j] != 1) {
            return;
        }
//        value[0] += 1;
        value.set(0, value.get(0) + 1);
        m[i][j] = -1;
        check(m, i + 1, j, row, column, value);
        check(m, i - 1, j, row, column, value);
        check(m, i, j + 1, row, column, value);
        check(m, i, j - 1, row, column, value);
        check(m, i + 1, j + 1, row, column, value);
        check(m, i + 1, j - 1, row, column, value);
        check(m, i - 1, j + 1, row, column, value);
        check(m, i - 1, j - 1, row, column, value);
    }
}

