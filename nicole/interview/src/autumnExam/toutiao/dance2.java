package autumnExam.toutiao;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author NicoleChen
 * @date 2018/8/12 10:02
 */
public class dance2 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int lines = Integer.valueOf(s.nextLine());
        TreeMap<Integer, Integer> sym = new TreeMap();
        for (int i = 0; i < lines; i++) {
            String str1 = s.nextLine();
            for (String str2 : str1.split(";")) {
                String a = str2.split(",")[0];
                String b = str2.split(",")[1];
                sym.put(Integer.valueOf(a), Integer.valueOf(b));
            }
        }


        int start = -1;
        int end = -1;
        boolean flag = true;
        boolean newLine = true;
        for (int key : sym.keySet()) {
            if (newLine) {
                if (flag) {
                    flag = false;
                    start = key;
                    end = sym.get(key);
                }
                newLine = false;
            }
            if (key <= end) {
                int temp = sym.get(key);
                if (temp < end)
                    continue;
                end = temp;
                continue;
            }

            System.out.print(start + "," + end + ";");
            start = key;
            end = sym.get(key);
            newLine = true;
        }

        System.out.print(start + "," + end);
    }
}
