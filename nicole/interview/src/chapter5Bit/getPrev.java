package chapter5Bit;

/**
 * @author NicoleChen
 * @date 2018/3/28 21:21
 */
public class getPrev {
    public static int getPrev(int num){
        int c = num;
        int c1 = 0;
        int c0 = 0;
        while((c&1) == 1 ){
            c1++;
            c >>= 1;
        }
        if(c == 0){
            return -1;
        }
        while((c&1) == 0 && (c != 0)){
            c0++;
            c >>= 1;
        }
        if(c1+c0 == 31 || c1+c0 == 0){
            return -1;
        }
        //System.out.println(c0+" "+c1);
        int p = c0+c1;
        num &= ((~0)<<(p+1));
        //num &= ~((1<<p+1)-1);
        //System.out.println(Integer.toBinaryString(num));
        num |= ((1<<(c1+1))-1)<<(c0-1);


        System.out.println(Integer.toBinaryString(num));
        return num;


    }

    private static int swapOddEvenBits(int i) {
        return ((i & 0xaaaaaaaa)>>1) |((i & 0x55555555)<<1);
    }
    public static void main(String[] args) {
        int num = 13948;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(getPrev(num));
        String str= "0101010101010101";
        int a = Integer.parseInt(str,2);
        String str1= Integer.toHexString(a);
        System.out.println(str1);
        String b = Integer.toBinaryString(swapOddEvenBits(num));
        System.out.println(b);
    }


}
