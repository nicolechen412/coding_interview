package autumnExam.xiecheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/4 18:26
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        //System.out.println(count);
        int timeRange = sc.nextInt();
        //System.out.println(timeRange);
        sc.nextLine();
        ArrayList<Integer> array = new ArrayList();
        int times = 0;
        while(times < count){
            String[] str = sc.nextLine().split(" ");
            System.out.println(str[0]);
            if(Integer.parseInt(str[1]) <= timeRange && Integer.parseInt(str[2]) >= timeRange){
                array.add(Integer.parseInt(str[0]));
                //System.out.println(str[0]);

            }
            times++;
        }
        if(array.size() == 0){
            System.out.println("null");
        }
        Collections.sort(array);
        for (Integer anArray : array) {
            System.out.println(anArray);
        }
    }
}
