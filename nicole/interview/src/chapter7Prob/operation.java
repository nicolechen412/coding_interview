package chapter7Prob;

/**
 * @author NicoleChen
 * @date 2018/4/16 10:15
 */
public class operation {



    public static int negate(int a){
        int neg = 0;
        int d = (a>0) ? -1 : 1;
        while(a != 0){
            neg += d;
            a = a+d;
        }
        return neg;
    }
    public static int minus(int a, int b){ //减法
        return a + negate(b);
    }
    public static int multiply(int a, int b){//乘法
        if(a < b){
            return multiply(b,a);
        }
        int sum = 0;
        for(int i = 0; i<abs(b); i++){
            sum += a;
        }
        if(b < 0){
            sum =  negate(sum);
        }
        return sum;
    }
    static int abs(int a){
        if(a<0){
            return negate(a);
        }else{
            return a;
        }
    }
    static int divide(int a, int b){
        if(b == 0){
            throw new RuntimeException("除数为0");
        }
        int absa = abs(a);
        int absb = abs(b);
        int product = 0;
        int x = 0;
        while(product + absb <= absa){
            product += absb;
            x++;
        }
        if((a>0 && b>0) || (a<0 && b<0)){
            return x;
        }else {
            return negate(x);
        }
    }
    public static void main(String[] args) {
        int a = 3;
        int b = 9;
        int c = minus(a,b);
        int d = multiply(a,b);
        int e = divide(b,a);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
