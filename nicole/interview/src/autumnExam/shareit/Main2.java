package autumnExam.shareit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/10/12 14:39
 */
public class Main2 {
    public static ArrayList<String> resList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m, n;
        n = scanner.nextInt();
        m = scanner.nextInt();
        findAllAnswer(n, m);
        resList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String str : resList) {
            System.out.println(str);
        }

        return;
    }

    public static void findAllAnswer(int n, int dest) {
        int[] arr = new int[n];
        helper(dest, 0, arr, n);
    }

    public static void helper(int dest, int i, int[] arr, int n) {

        if (dest == 0)
            prints(arr, n);
        if (dest <= 0 || i == n)
            return;
        helper(dest, i + 1, arr, n);
        arr[i] = 1;
        helper(dest - i - 1, i + 1, arr, n);
        arr[i] = 0;
    }

    public static void prints(int[] arr, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                sb.append((i + 1) + " ");
            }
//                System.out.print((i + 1) + " ");

        }
//        System.out.println();

        resList.add(sb.toString());
    }
}
