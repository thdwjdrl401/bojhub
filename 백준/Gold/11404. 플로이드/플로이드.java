import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	static int INF = Integer.MAX_VALUE / 4;
	
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
        	Arrays.fill(map[i], INF);
		}
        
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	if(map[a][b] == 0 || map[a][b] > c) map[a][b] = c;
        	
		}
        
        for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if(i == k) continue;
 				for (int j = 1; j <= n; j++) {
 					if(j == k || j == i) continue;
 					
 					int cal = map[i][k] + map[k][j];
					if(cal > INF) continue;
					if(map[i][j] > cal) map[i][j] = cal;
				}
			}
		}
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= n; j++) {
        		if(map[i][j] == INF) map[i][j] = 0;
        		sb.append(map[i][j] + " ");	
			}
        	sb.append('\n');
		}
        System.out.println(sb);
	}
}