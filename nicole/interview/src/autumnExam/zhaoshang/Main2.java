package autumnExam.zhaoshang;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/8/30 18:48
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] price = sc.nextLine().split(" ");
            int[] prices = new int[price.length];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Integer.parseInt(price[i]);
            }

            int maxProfit = 0;
            int cur = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i+1; j < prices.length; j++) {
                    if(prices[i] < prices[j]){
                        cur = prices[j] - prices[i];
                        maxProfit = cur > maxProfit ? cur : maxProfit;
                    }
                }
            }
            System.out.println(maxProfit);

            /*for (int c:prices) {
                System.out.println(c);
            }*/
        }

    }
}
