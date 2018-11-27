package autumnExam.tencent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/9/16 9:54
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(n+1);
        ArrayList<Integer> array2 = new ArrayList<>();
        for (int i = 1; i <= n+1; i++) {
            array2.add(i);
        }
        n = n+1;
        while(getLCM(array1) != getLCM(array2)){
            n++;
            array1.add(n);
            array2.add(n);
        }
        System.out.println(n);


    }

   /* static int getLCM(ArrayList<Integer> array){
        int max=0;
        for(int i=0;i<array.size();i++){

            if(max<array.get(i)){
                max=array.get(i);
            }
        }
        for(int i=max;;i++){
            boolean b=true;
            for(int j=0;j<array.size();j++){
                if(max % array.get(j)!=0){
                    b=false;

                }
            }
            max++;
            if(b){
                return i;

            }

        }
    }*/
    public static long commonDivisor(long n, long m) {
        while (n % m != 0) {
            long temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }

    public static long commonMultiple(long n, long m) {
        return n * m / commonDivisor(n, m);
    }


    public static long getLCM(ArrayList<Integer> array) {
        long value = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            value = commonMultiple(value, array.get(i));
        }
        return value;


    }
}
