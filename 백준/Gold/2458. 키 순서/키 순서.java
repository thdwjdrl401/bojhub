import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static boolean[][] map;
	
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N+1][N+1];
        for (int i = 0; i <= N; i++) {
			map[i][i] = true;
		}
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
//			map[b][a] = true;
		}
        
        for (int k = 1; k <= N; k++) {
        	for (int i = 1; i <= N; i++) {
        		for (int j = 1; j <= N; j++) {
					if(map[i][k] && map[k][j]) map[i][j] = true;
				}
			}
		}
        int result = 0;
        for (int i = 1; i <= N; i++) {
        	boolean x = true;
        	for (int j = 1; j <= N; j++) {
        		if(!map[i][j] && !map[j][i]) {
        			x = false;	
        			break;
        		}
			}
        	if(x) result++;
		}
        System.out.println(result);
	}
}