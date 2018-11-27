package autumnExam.toutiao;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author NicoleChen
 * @date 2018/8/12 10:02
 */
public class dance5 {
    private static int M;
    private static TreeMap<Integer, Integer> treeMap = new TreeMap();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int people = Integer.valueOf(s.nextLine());
        M = Integer.valueOf(s.nextLine());
        String str = s.nextLine();
        String[] strings = str.split(" ");
        for (int i = 0; i < people; i++) {
            treeMap.put(Integer.valueOf(strings[i*2]), Integer.valueOf(strings[i*2 + 1]));
        }

        int start = -1;
        int end = -1;
        boolean newLine = true;
        int result = 1;
        for (int key : treeMap.keySet()) {
            if (newLine) {
                start = key;
                end = treeMap.get(key);
                newLine=false;
            }
            if (key < end){
                int newEnd = getNewEnd(key);
                if (newEnd<end){
                    end = newEnd;
                    start = key;
                }

                continue;
            }

            newLine = true;
            result++;
        }
        System.out.println(result);

    }

    private static int getNewEnd(int key){
        int newEnd = treeMap.get(key);
        if (newEnd==0)
            newEnd=M;
        return newEnd;
    }
}
