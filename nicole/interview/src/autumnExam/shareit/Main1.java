package autumnExam.shareit;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/10/12 14:39
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        if(str1.length == 0){
            for (String str : str1) {
                System.out.print(str + " ");
//                System.out.print(" ");
            }
            return;
        }else if(str2.length == 0){
            for (String str : str2) {
                System.out.print(str + " ");
//                System.out.print(" ");
            }
            return;
        }
        long[] num1 = new long[str1.length];
        long[] num2 = new long[str2.length];

        for (int i = 0; i < str1.length; i++) {
            num1[i] = Long.parseLong(str1[i]);
        }
        for (int i = 0; i < str2.length; i++) {
            num2[i] = Long.parseLong(str2[i]);
        }
        LinkedList<Long> list = new LinkedList<>();
        for (int i = 0; i < num1.length; i++) {
            list.add(num1[i]);
        }
        for (int i = 0; i < num2.length; i++) {
            list.add(num2[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }

    }
}
