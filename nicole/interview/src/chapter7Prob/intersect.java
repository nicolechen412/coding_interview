package chapter7Prob;

/**
 * @author NicoleChen
 * @date 2018/4/16 10:06
 */
public class intersect {
    public static void main(String[] args) {
        Line line1 = new Line(0.5,2);
        Line line2 = new Line(0.5,1.99999999);
        System.out.println(line1.intersect(line2));
    }
}

class Line{
    static double epsilon = 0.0000001;
    public double slope;//斜率
    public double yintercept;//在y轴的截距

    public Line(double s, double y){
        slope = s;
        yintercept = y;
    }



    public boolean intersect(Line line2){
        return Math.abs(slope - line2.slope) > epsilon ||
                Math.abs(yintercept - line2.yintercept) < epsilon;
    }
}
