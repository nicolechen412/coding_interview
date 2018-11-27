package autumnExam.iqiyi;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/15 9:56
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int foodClass = sc.nextInt();
        sc.nextInt();
        int days = sc.nextInt();
        //int askDay = sc.nextInt();
        sc.nextInt();

        sc.nextLine();

        char[] foods = sc.nextLine().toCharArray();
        int[] foodss = new int[foods.length];
        for (int i = 0; i < foods.length; i++) {
            foodss[i] = foods[i] - '0';
            //System.out.println(foods[i]);
        }

        String[] everyDay;
        int change;
        //int count = days;
        while(days > 0){
            everyDay = sc.nextLine().split(" ");
            if(everyDay[0].equals("B")){
                change = Integer.parseInt(everyDay[1]);
                foodss[change-1] -= 1;
            }
            if(everyDay[0].equals("A")){
                change = Integer.parseInt(everyDay[1]);
                foodss[change-1] += 1;
            }
            days--;
        }
        int max = 0;
        int maxNum = 0;
        for (int i = 0; i < foodss.length; i++) {
            if(foodss[i] > max){
                max = foodss[i];
                maxNum = i;
            }
        }

        System.out.println(maxNum+1);
    }
}
