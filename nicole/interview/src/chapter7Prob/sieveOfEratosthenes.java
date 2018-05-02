package chapter7Prob;

/**
 * @author NicoleChen
 * @date 2018/4/11 9:56
 */
public class sieveOfEratosthenes {
    //普通的素数检查方法
    public static boolean primeSlightlyBetter(int n){
        if(n<2) return false;
        for(int i = 2; i<Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
         return true;


    }
    //检查是否为素数，埃拉托斯特尼筛法
    public static boolean[] sieveOfEratosthenes(int max){
        boolean[] flags = new boolean[max+1];
        int prime = 2;
        init(flags);
        while (prime<=max){
            crossOff(flags,prime);
            prime = getNextPrime(flags,prime);
            if(prime>=max)
                break;
        }
        return flags;
    }

    private static int getNextPrime(boolean[] flags, int prime) {
        int next = prime+1;
        while(next<flags.length && !flags[next]){
            next++;
        }
        return next;
    }

    private static void crossOff(boolean[] flags, int prime) {
        for(int i = prime*prime; i<flags.length; i+=prime){
            flags[i] = false;
        }
    }

    private static void init(boolean[] flags) {
        for(int i = 2; i<flags.length; i++){
            flags[i] = true;
        }
    }

    public static void main(String[] args) {
        int max = 19;
        /*boolean[] flags = sieveOfEratosthenes(max);
        if(flags[max]){
            System.out.println(true);
        }else{
            System.out.println(false);
        }*/
        System.out.println(primeSlightlyBetter(max));
    }
}
