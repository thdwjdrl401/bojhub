import java.io.*;
import java.util.*;


public class Main {
	
	static int N;
	static int[][] map;
	static int[][] dp;
	static int result = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        for (int i = 0; i < N; i++) {
        	Arrays.fill(dp[i],  -1);
		}
        for (int i = 0; i < 3; i++) {
        	
        	result = Math.min(result, dp(0, i));
		}
        System.out.println(result);
    }
    
    static int dp(int depth, int color) {
    	if(depth == N - 1) {
    		int min = Integer.MAX_VALUE;
    		for (int i = 0; i < 3; i++) {
				if(i == color) continue;
				min = Math.min(min, map[depth][i]);
			}
    		return min;
    	}
    	
    	if(dp[depth][color] != -1) return dp[depth][color];
    	

    	
    	int min = Integer.MAX_VALUE;
    	for (int i = 0; i < 3; i++) {
    		if(i == color) continue;
    		
			min = Math.min(min, map[depth][i] + dp(depth + 1, i));
		}
    	
    	return dp[depth][color] = min;
    }
}
