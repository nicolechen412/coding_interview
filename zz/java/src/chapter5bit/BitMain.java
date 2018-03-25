package chapter5bit;

import static java.lang.System.out;

public class BitMain {

    public static void main(String[] args) {
//        out.println(bitInsert(1024, 19, 2, 6));
//        out.println(bitInsert(4355, 4, 2, 7));

//        out.println(printBin(0.75));

        out.println(binSwapRequired(8, 3));
    }


    public static int bitInsert(int n, int m, int i, int j){
        // 1011 0101 假设对2到5为操作
        // 第一步是对10 1101 01的2到5位清0，得到10 0000 01
        int allOne = ~0; // 1111 1111
        int left = allOne << (j+1); // 1100 0000
        int right = ((1 << i) - 1); // 0000 0011
        int mask = left | right;    // 1100 0011
        n = n & mask;
        // 第二步是对m移位
        m = m << j;
        // 第三步是合并
        n = n | m;
        return n;
    }

    public static String printBin(double num) {
        if(num >= 1 || num <= 0)
            return "error";
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while(num > 0){
            if(sb.length() >= 32)
                return "error";
            double tmp = num * 2;
            if(tmp >= 1){
                num = tmp -1;
                sb.append(1);
            }else{
                num = tmp;
                sb.append(0);
            }
        }

        return sb.toString();
    }

    public static int binSwapRequired(int a, int b){
        int c = a ^ b;
        int count = 0;
        while(c > 0){
            if((c & 1) == 1){
                count++;
            }
            c = c >> 1;
        }
        return count;
    }
    public static int binSwapRequired2(int a, int b){
        //理解c&(c-1)的作用是清楚一个最低有效位，也就是最低为1的位变为0
        //c-1会把c最低为1的位变为0，比如10100，那么减1得到10011，执行&操作得到的是10000，可见把最后一个1消掉了。
        //(c&(c-1))==0是什么意思呢，假设c是xyz100，那么c-1是xyz011，&操作想到得到结果是0，那么xyz肯定是0，所以c这个数一定是2的幂次方

        int count = 0;
        for(int c = a ^ b; c != 0; c = c&(c-1))
            count++;
        return count;

    }

}
