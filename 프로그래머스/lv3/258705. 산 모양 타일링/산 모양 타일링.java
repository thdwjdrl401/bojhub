import java.util.*;

class Solution {
	
	int[] dp;
	final int MOD = 10007;
	
    public int solution(int n, int[] tops) {
        
        dp = new int[2 * n + 2];
        
        dp[1] = 1;
        if(tops[0] == 1) dp[2] = 3;
        else dp[2] = 2;
        
        for (int i = 3; i <= 2 * n + 1; i++) {
			if(i % 2 == 0) {
				if(tops[i / 2 - 1] == 1) dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % MOD;
				else dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
			} else dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
		}
        return dp[2 * n + 1];
    }
}