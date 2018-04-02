package chapter5Bit;

/**
 * @author NicoleChen
 * @date 2018/3/28 9:07
 */
public class updateBits {
    static int updateBits(int n, int m, int i, int j){
        int num = ((1<<i)-1)| (~0<<(j+1));
        num = num & n;
        m = m<<i;
        n = num | m;
        return n;
    }

    public static void main(String[] args) {
        int n = 1024;
        int m = 19;
        int i = 2;
        int j = 6;
        System.out.println(updateBits(n,m,i,j));
    }
}
