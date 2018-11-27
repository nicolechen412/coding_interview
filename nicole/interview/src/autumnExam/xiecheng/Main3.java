package autumnExam.xiecheng;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/4 18:26
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cacheSize = sc.nextInt();
        int curSize = cacheSize;
        String[][] strings = new String[cacheSize][2];
        int LRU = 0;
        while(sc.hasNext()){
            String[] str = sc.nextLine().split(" ");
            //System.out.println(str[0]);
            if(str[0].equals("g")){
                for (int i = 0; i < strings.length; i++) {
                    if(strings[i][0].equals(str[1])){
                        System.out.println(strings[i][1]);
                        //LRU =;
                    }
                }
            }
            if(str[0].equals("p")){
                if(curSize == 0){

                }
            }
        }
    }
}
