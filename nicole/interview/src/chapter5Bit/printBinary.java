package chapter5Bit;

/**
 * @author NicoleChen
 * @date 2018/3/28 10:50
 */
public class printBinary {
    public static String printBinary(double d){
        if(d <0 || d>1){
            return "Error";
        }
        StringBuilder binary = new StringBuilder();
        binary.append("0.");
        while(d>0){
            if(binary.length()>=32){
                return "Error";
            }
            double r = d*2;
            if(r>=1){
                binary.append(1);
                d = r-1;
            }else{
                binary.append(0);
                d = r;
            }
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        double d = 0.625;
        System.out.println(printBinary(d));
    }
}
