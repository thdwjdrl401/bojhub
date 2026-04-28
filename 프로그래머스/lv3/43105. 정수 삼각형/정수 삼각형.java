import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        dp[0] = new int[]{triangle[0][0]};
        int max = 0;
        for(int i = 1; i < triangle.length; i++){
            int[] cur = triangle[i];
            dp[i] = new int[cur.length];
            for(int j = 0; j < cur.length; j++){
                if(j == 0) dp[i][j] = triangle[i][j] + dp[i-1][j];
                else if(j == cur.length - 1) dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                else dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}