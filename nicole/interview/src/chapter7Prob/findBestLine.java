package chapter7Prob;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author NicoleChen
 * @date 2018/4/23 11:35
 *
 * 未完成的题
 */
public class findBestLine {
    Line2 findBestLine(GraphPoint[] points){
        Line2 bestLine = null;
        int bestCount = 0;
        HashMap<Double, ArrayList<Line2>> linesBySlope = new HashMap<>();
        for(int i = 0; i<points.length; i++){
            for(int j = i+1; j<points.length; j++){
                Line2 line = new Line2(points[i],points[j]);
                insertLine(linesBySlope,line);
                int count = countEquivalentLines(linesBySlope,line);
                if(count > bestCount){
                    bestLine = line;
                    bestCount = count;
                }
            }
        }
        return null;
    }

    private int countEquivalentLines(HashMap<Double, ArrayList<Line2>> linesBySlope, Line2 line) {
        double key = Line2.floorToNearestEpsilon(line.slope);
        double eps = Line2.epsilon;
        //int count = countEquivalentLines(linesBySlope.get(key),line) +
        //        countEquivalentLines(linesBySlope)
        return 0;
    }

    private void insertLine(HashMap<Double,ArrayList<Line2>> linesBySlope, Line2 line) {
        ArrayList<Line2> lines = null;
        double key = Line2.floorToNearestEpsilon(line.slope);
        if(!linesBySlope.containsKey(key)){
            lines = new ArrayList<Line2>();
            linesBySlope.put(key,lines);
        }else{
            lines = linesBySlope.get(key);
        }
        lines.add(line);
    }

    public static void main(String[] args) {
        GraphPoint[] points = new GraphPoint[6];
        points[0] = new GraphPoint(2,3);
    }
}
class GraphPoint{
    int x;
    int y;

    public GraphPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Line2{
    public static double epsilon = .0001;
    public double slope,intercept;    //斜率，截距
    private boolean infinite_slope = false;

    public Line2(GraphPoint p,GraphPoint q) {
        if(Math.abs(p.x - q.x) > epsilon){
            slope = (p.y - q.y) / (p.x - q.x);
            intercept = p.y - slope * p.x;
        }else{
            infinite_slope = true;  //斜率无穷大
            intercept = p.x;    //x轴截距
        }
    }

    public static double floorToNearestEpsilon(double slope) { //???
        int r = (int)(slope/epsilon);
        return ((double)r) * epsilon;
    }
}