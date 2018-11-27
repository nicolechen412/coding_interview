package autumnExam.iqiyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/15/2018 9:56 AM
 * desc  :
 */
/*
3 4 2
5 3 1
B 1
A 2
A 2
A 3
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int foodClass, days, sortFood;
        foodClass = scanner.nextInt();
        days = scanner.nextInt();
        sortFood = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Integer> array = new ArrayList<>(foodClass);
        ArrayList<Integer> arrayList = new ArrayList<>(foodClass);
        for(int i = 0; i < foodClass; i++){
            array.add(scanner.nextInt());
        }
        scanner.nextLine();

        int value;
        for(int i = 0; i < days; i++){
            String[] strs = scanner.nextLine().split(" ");
            value = Integer.parseInt(strs[1]);
            int tmp = array.get(value - 1);
            if("A".equals(strs[0]))
                array.set(value-1, tmp + 1);
            else
                array.set(value-1, tmp - 1);

        }
        int x = array.get(sortFood-1);
        Collections.sort(array);
        Collections.reverse(array);


        arrayList.add(0, 1);
        for(int i = 1; i < array.size(); i++){
            int tmp = array.get(i-1);
            if(array.get(i)==tmp){
                arrayList.add(i, tmp);
            }else{
                arrayList.add(i, tmp+1);
            }
        }

        System.out.println(arrayList.get(array.indexOf(x)));


    }
}
