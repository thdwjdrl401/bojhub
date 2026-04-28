import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       	StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[M + 1];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int V = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
        	int cnt = 1;
        	while(K > 0) {
        		int take = Math.min(cnt, K);
        		int weight = V * take;
        		int value = C * take;
        		for (int w = M; w >= weight; w--) {
        			dp[w] = Math.max(dp[w],  dp[w - weight] + value);
        		}
        		K -= take;
        		cnt <<= 1;
        	}
		}
    	System.out.println(dp[M]);

    }
}