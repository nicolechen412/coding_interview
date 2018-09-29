package newCoder;

import java.util.Arrays;

/**
 * @author NicoleChen
 * @date 2018/9/28 22:12
 */
public class Code_06_dp {
    public static void main(String[] args) {
        int[] seq = {2,1,5,3,6,4,8,9,7};
        int[] res = LIS(seq);
        Arrays.sort(res);
        System.out.println(res[res.length-1]);
    }
    private static int[] LIS(int[] sequence){  //最长递增子序列
        int[] dp = new int[sequence.length];
        dp[0] = 1;
        int max;
        for (int i = 1; i < sequence.length; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if(sequence[j] < sequence[i]){
                    max = max > sequence[j] ? max : dp[j]+1;
                }
            }
            if(max == 0) {
                dp[i] = 1;
            }else{
                dp[i] = max;
            }

        }
        return dp;
    }
    private static int minPathSum(int[][] m){
        if(m == null || m.length == 0|| m[0] == null || m[0].length == 0){
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int dp[][] = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < m.length; i++) {
            dp[i][0] = dp[i-1][0] + m[i][0];
        }
        for (int i = 0; i < m[0].length; i++) {
            dp[0][i] = dp[0][i-1] + m[0][i];
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + m[i][j];
            }
        }
        return dp[row-1][col-1];

    }

    private int[][]  LongestCommonSeq(String str1[], String str2[]){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 0; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],str1[i] == str2[0] ? 1 : 0);
        }
        for (int i = 0; i < str2.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1],str1[0] == str2[i] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(str1[i] == str2[j]) dp[i][j] = Math.max(dp[i][j] , dp[i-1][j-1] + 1);
            }
        }
        return dp;
    }

    private static int[][] LongestCommonChuan(String[] str1, String[] str2){
        int[][] dp = new int[str1.length][str2.length];

        for (int i = 0; i < str1.length; i++) {
            if(str1[i] == str2[0]){
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < str2.length; i++) {
            if(str1[0] == str2[i]){
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if(str1[i] == str2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp;
    }
}
