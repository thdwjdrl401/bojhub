import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
//	static boolean[] visited;
	static int[][] dp;
	static int result;
	static int min = Integer.MAX_VALUE;
    static final int INF = 1_000_000_000;

	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		int cur = Integer.parseInt(st.nextToken());
        		map[i][j] = cur;
			}
		}
        for (int i = 0; i < N; i++) {
        	Arrays.fill(dp[i], -1);
		}
        
        System.out.println(dfs(0, 1));
	}
	
	static int dfs(int cur, int visited) {
		if(visited == (1 << N) - 1) {
			if(map[cur][0] == 0) return INF;
			return map[cur][0];
		}
		
		if(dp[cur][visited] != -1) {
			return dp[cur][visited];
		}
		
		dp[cur][visited] = INF;
		
		
		for (int i = 0; i < N; i++) {
			if((visited & (1 << i)) != 0) continue;
			
			if(map[cur][i] == 0) continue;
			
			dp[cur][visited] = Math.min(dp[cur][visited], map[cur][i] + dfs(i, visited | (1 << i)));
		}
		return dp[cur][visited];
	}
}
