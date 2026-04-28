import java.io.*;
import java.util.*;

public class Main {
	static int N;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][2];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
        dfs(0);
        System.out.println(max);
    }
    
    static void dfs(int depth) {
    	if(depth == N) {
    		int count = 0;
    		for (int i = 0; i < N; i++) {
    			if(map[i][0] <= 0) count++;
			}
    		max = Math.max(max, count);
    		return;
    	} 
    	
    	int[] handsEgg = map[depth];
		if(handsEgg[0] <= 0) {
			dfs(depth + 1);
			return;
		}
		boolean hit = false;
    	for (int i = 0; i < N; i++) {
    		if(depth == i) continue;
    		int[] nextEgg = map[i];
    		if(nextEgg[0] <= 0) continue;
    		hit = true;
    		handsEgg[0] -= nextEgg[1];
    		nextEgg[0] -= handsEgg[1];
			dfs(depth + 1);
			handsEgg[0] += nextEgg[1];
    		nextEgg[0] += handsEgg[1];
		}
    	if(!hit) dfs(depth + 1);
    }
}