package autumnExam.toutiao;

import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/8/25 9:58
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num > 24){
            System.out.println(24);
        }else{
            System.out.println(num);
        }

    }
}
