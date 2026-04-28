import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] metrix;
	static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        metrix = new int[N][2];
        dp = new int [N][N];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());			
        	metrix[i][0] = r;
        	metrix[i][1] = c;
		}
        
        for (int i = 0; i < N; i++) {
        	Arrays.fill(dp[i],  -1);
		}
        
        for (int i = 0; i < N; i++) {
        	dp[i][i] = 0;	
		}
        System.out.println(dp(0, N - 1));
        
    }
    static int dp(int from, int to) {
    	if(dp[from][to] != -1) return dp[from][to];
    	
    	if(Math.abs(to - from)  == 1) {
    		return dp[from][to] = metrix[from][0] * metrix[from][1] * metrix[to][1];
    	}
    	
    	int min = Integer.MAX_VALUE;
    	for (int i = from; i < to; i++) {
    		int left = dp(from, i);
    		int right = dp(i + 1, to);
            int cost = metrix[from][0] * metrix[i][1] * metrix[to][1];
            min = Math.min(min, left + right + cost);
		}
    	
    	return dp[from][to] = min;
    }
}