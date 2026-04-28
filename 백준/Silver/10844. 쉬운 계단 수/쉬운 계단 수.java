import java.io.*;
import java.util.Arrays;

public class Main {

    static int N;
    static int[][] dp;
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][10];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        int result = 0;
        for (int i = 1; i <= 9; i++) {
            result = (result + dp(N, i)) % MOD;
        }
        System.out.println(result);
    }

    static int dp(int leftLength, int curNum) {

        if (dp[leftLength][curNum] != -1) {
            return dp[leftLength][curNum];
        }

        if (curNum == 0) return dp[leftLength][curNum] = dp(leftLength - 1, 1);
        else if (curNum == 9) return dp[leftLength][curNum] = dp(leftLength - 1, 8);

        return dp[leftLength][curNum] =
                (dp(leftLength - 1, curNum + 1) + dp(leftLength - 1, curNum - 1)) % MOD;
    }
}