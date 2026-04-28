import java.io.*;
import java.util.*;


public class Main {
	
	static int n, k;
	static int[] arr;
	static int[] dp;
	static final int INF = 10_000_000;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
		}
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        int result = dp(k);
        System.out.println(result >= INF ? -1 : result);
        
    }
    
    static int dp(int leftK) {
    	if(leftK == 0) return 0;
    	else if(leftK < 0) return INF;
    	
    	if(dp[leftK] != -1) return dp[leftK];
    	
    	int min = Integer.MAX_VALUE;
    	for (int i = 0; i < n; i++) {
			min = Math.min(min, dp(leftK - arr[i]) + 1);
		}
    	
    	return dp[leftK] = min;
    }
}
