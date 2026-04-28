import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static int[][] dp; // dp[curCity][visited]
	static int maxVisited;
	static final int INF = 100_000_000;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        maxVisited = 1 << N;
        dp = new int[N][maxVisited];
        for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
        System.out.println(dp(0, 1));
    }
    
    static int dp(int curCity, int visited) {
    	if(visited == maxVisited - 1) {
    		if(map[curCity][0] == 0) return INF;
    		return map[curCity][0];
    	}
    	
    	if(dp[curCity][visited] != -1) return dp[curCity][visited];
    	
    	int min = INF;
    	for (int i = 0; i < N; i++) {
			int bitI = 1 << i;
			if((visited & bitI) != 0) continue;
			if(map[curCity][i] == 0) continue;
			min = Math.min(min, dp(i, visited | bitI) + map[curCity][i]);
		}
    	
    	return min;
    }
}