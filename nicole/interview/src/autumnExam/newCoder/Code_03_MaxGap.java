package autumnExam.newCoder;

/**
 * @author NicoleChen
 * @date 2018/5/4 15:54
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序。
 */
public class Code_03_MaxGap {
    public static int MaxGap(int[] num){
        if(num == null || num.length<2) return 0;

        int len = num.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<len; i++){
            min = Math.min(num[i],min);
            max = Math.max(num[i],max);
        }

        if(min == max) return 0;

        boolean[] hasNum = new boolean[len+1];
        int[] maxs = new int[len+1];
        int[] mins = new int[len+1];
        int bid = 0;
        for(int j = 0; j<len; j++){
            bid = bucket(num[j], len, min, max);
            maxs[bid] = hasNum[bid] ? Math.max(num[j],maxs[bid]) : num[j];
            mins[bid] = hasNum[bid] ? Math.min(num[j],mins[bid]) : num[j];
            hasNum[bid] = true;
        }
        int lastMax = maxs[0];
        int res = 0 ;
        for(int k = 1; k<=len; k++){
            if(hasNum[k]){
                res = Math.max(lastMax,mins[k]-lastMax);
                lastMax = maxs[k];
            }

        }
        return res;
    }

    private static int bucket(int num, int len, int min, int max) {
        return ((num - min) * len) / (max - min);
    }

    public static void main(String[] args) {
        int[] num = new int[]{34,16,74,5, 27,34,58,63,74};
        System.out.println(MaxGap(num));
    }
}
