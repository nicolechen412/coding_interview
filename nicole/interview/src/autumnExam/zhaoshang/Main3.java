package autumnExam.zhaoshang;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/8/30 18:48
 */
public class Main3 {
    public static void main(String[] args) {
        //System.out.println(Math.ceil(7/(double)3));
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int hours = sc.nextInt();

        //System.out.println(hours);
        int[] food = new int[str.length];
        int maxFood = 0;
        for (int i = 0; i < food.length; i++) {
            food[i] = Integer.parseInt(str[i]);
            //System.out.println("food[i]:" + food[i]);
            if(food[i] > maxFood) maxFood = food[i];
        }
        //System.out.println("maxfood:" + maxFood);
        //System.out.println("hours:" + hours + " ,food.length" + food.length);
        if(hours == food.length){
            System.out.println(maxFood);
        }else{


            int sumFood = 0;
            for (int i = 0; i < food.length; i++) {
                sumFood += food[i];
            }
            //System.out.println("sumfood:" + sumFood);
            int min = (int) Math.ceil(sumFood / (double)hours);
            //System.out.println("min:" + min);
            int times = 0;

            for (int i = 0; i < food.length; i++) {
                times += food[i]/min;
                if(food[i] % min != 0){
                    times++;
                }
            }
            if(times == hours){
                System.out.println(min);
            }else{
                min++;
                while(times > hours){
                    for (int i = 0; i < food.length; i++) {
                        times += food[i]/min;
                        if(food[i] % min != 0){
                            times++;
                        }
                    }
                    min++;
                }
                System.out.println(min);
            }




        }

    }
}
