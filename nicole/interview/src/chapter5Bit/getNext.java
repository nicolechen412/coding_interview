package chapter5Bit;

/**
 * @author NicoleChen
 * @date 2018/3/28 11:47
 */
public class getNext {
    public static int getNext(int num){
        int c = num;
        int c0 = 0;
        int c1 = 0;
        while((c&1)==0 && c!=0){
            c0++;
            c>>=1;
        }
        //System.out.println(c0);
        while((c&1)==1 ){
            c1++;
            c>>=1;
        }
        //System.out.println(c1);
        if((c0+c1) == 31 || c1+c0 == 0){
            return -1;
        }
        int p= (c0+c1);
        /*num |= 1<<p;
        num &= ~((1<<p)-1);//等于~0<<p
        num |= (1<<(c1-1)-1);*/

        num |= 1<<p;
        System.out.println(Integer.toBinaryString(num));
        num &= ~0<<p;
        System.out.println(Integer.toBinaryString(num));
        num |= (1<<(c1-1))-1;
        System.out.println(Integer.toBinaryString(num));


        return num;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(13948));
        System.out.println(getNext(13948));
    }
}
