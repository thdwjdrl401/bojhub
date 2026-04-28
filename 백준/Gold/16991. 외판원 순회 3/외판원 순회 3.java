import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int maxVisited;
	static int[][] W;
	static double[][] dp;
	static final double INF = Double.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][2];
        maxVisited = 1 << N;
        dp = new double[maxVisited][N];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	W[i][0] = x;
        	W[i][1] = y;
		}
        
        for (int i = 0; i < maxVisited; i++) {
        	Arrays.fill(dp[i], INF);
		}
        
        
        System.out.println(tsp(1, 0));
    }
    
    static double tsp(int visited, int curCity) {
    	if(visited == maxVisited - 1) {
    		return calDist(curCity, 0);
    	}
    	
        if (dp[visited][curCity] != INF) {
            return dp[visited][curCity];
        }
    	
    	
    	double min = Double.MAX_VALUE;
    	for (int i = 0; i < N; i++) {
    		int bitI = 1 << i;
    		if((visited & bitI) != 0) continue;
			min = Math.min(min, tsp(visited | bitI, i) + calDist(curCity, i));
		}
    	
    	return dp[visited][curCity] = min;
    }
    
    static double calDist(int index1, int index2) {
    	int dx = W[index1][0] - W[index2][0];
    	int dy = W[index1][1] - W[index2][1];
    	return Math.sqrt(dx * dx + dy * dy);
    }
}