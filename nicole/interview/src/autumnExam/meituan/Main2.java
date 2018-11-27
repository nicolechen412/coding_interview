package autumnExam.meituan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/6 18:31
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] target = new int[3];
        for (int i = 0; i < 3; i++) {
            target[i] = sc.nextInt();
            //System.out.println(num[i]);
        }
        //String[] target = sc.nextLine().split(" ");
        int n = target[0];
        int k = target[1];
        int t = target[2];
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            //System.out.println(num[i]);
        }

        int count = 0;
        for (int l = 0; l < n; l++) {
            for (int r = l+t; r < n; r++) {
                if(r-l+1 == k) {
                    if(calTimes(num, l, r, t)){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }

    private static boolean calTimes(int[] num, int l, int r, int t) {
        HashMap<Integer, Integer> times = new HashMap<>();
        int tmp;
        int max = Integer.valueOf(0);
        for (int i = l; i <= r; i++) {
            if(times.containsKey(num[i])){

                tmp = times.get(num[i]);
                //System.out.println(tmp);
                tmp++;
                times.put(num[i], tmp);
                if(tmp > max) max = tmp;

            }else{
                times.put(num[i], Integer.valueOf(1));

            }
        }
        if(max >= t) return true;
        return false;

    }
}
