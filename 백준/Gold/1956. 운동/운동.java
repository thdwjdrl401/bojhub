import java.io.*;
import java.util.*;

public class Main {

	static int V, E;
	static int[][] map;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new int[V+1][V+1];
        for (int i = 0; i <= V; i++) {
        	Arrays.fill(map[i], INF);
		}
        for (int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;
		}
        
        for (int k = 1; k <= V; k++) {
        	for (int i = 1; i <= V; i++) {
        		for (int j = 1; j <= V; j++) {
        			if(map[i][k] == INF || map[k][j] == INF) continue;
        			int sum = map[i][k] + map[k][j];
        			if(map[i][j] > sum) map[i][j] = sum;
        		}
			}
		}
        int result = INF;
        
        for (int i = 1; i <= V; i++) {
			for (int j = i + 1; j <= V; j++) {
    			if(map[i][j] == INF || map[j][i] == INF) continue;
				int sum = map[i][j] + map[j][i];
				result = Math.min(result, sum);
			}
		}
        System.out.println(result == INF ? -1 : result);
	}
}