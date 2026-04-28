import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static int[][] dr = { // dr[fromD][toD]
			{0, 0, 0},
			{0, 1, 1},
			{1, 1, 1}
	};
	static int[][] dc = { // dc[fromD][toD]
			{1, 0, 1},
			{0, 0, 0},
			{1, 1, 1}
	};
	static int[][][] dp;
	static final int INF = 1_000_000;

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
        dp = new int[N][N][3];
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
        dp[N - 1][N - 2][0] = 1;
        dp[N - 2][N - 1][1] = 1;
        dp[N - 2][N - 2][2] = 1;
        
        int result = dp(0, 0, 0);
        
//        for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.printf("%2d %2d %2d   ", dp[i][j][0] >= INF ? 0 : dp[i][j][0], dp[i][j][1] >= INF ? 0 : dp[i][j][1], dp[i][j][2] >= INF ? 0 : dp[i][j][2]);
//			}
//			System.out.println();
//		}
        System.out.println(result >= INF ? 0 : result);
    }
    
    static int dp(int r, int c, int d) {
    	if(dp[r][c][d] != -1) return dp[r][c][d];

    	int count = 0;
    	for (int i = 0; i < 3; i++) {
    		if(!canRoll(d, i)) {
    			continue;
    		}
			if(!check(r, c, d, i)) {
				continue;
			}
			count += dp(r + dr[d][i], c + dc[d][i], i);
		}
    	return dp[r][c][d] = count;
    }
    
    static boolean check(int r, int c, int fromD, int toD) {
    	if(fromD == 0) { // from 가로
    		if(toD == 0) return c + 2 < N && map[r][c + 2] == 0;
    		else if(toD == 2) return c + 2 < N && r + 1 < N && map[r][c + 2] == 0 && map[r + 1][c +2] == 0 && map[r + 1][c + 1] == 0; 
    	} else if (fromD == 1) { // 세로
    		if(toD == 1) return r + 2 < N && map[r + 2][c] == 0;
    		else if(toD == 2) return r + 2 < N && c + 1 < N && map[r + 2][c] == 0 && map[r + 2][c +1] == 0 && map[r + 1][c + 1] == 0;
    	} else { // 대각선
    		if(toD == 0) return r + 1 < N && c + 2 < N && map[r + 1][c + 2] == 0;
    		else if(toD == 1) return r + 2 < N && c + 1 < N && map[r + 2][c + 1] == 0;
    		else return r + 2 < N && c + 2 < N && map[r + 2][c + 2] == 0 && map[r + 2][c +1] == 0 && map[r + 1][c + 2] == 0;
    	}
    	return false;
    }
    
    static boolean canRoll(int from, int to) {
    	if(from == 0) {
    		if(to != 1) return true;
    	}
    	if(from == 1) {
    		if(to != 0) return true;
    	}
    	if(from == 2) return true;
    	return false;
    }
}