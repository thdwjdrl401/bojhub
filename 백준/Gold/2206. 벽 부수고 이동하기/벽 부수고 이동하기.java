import java.io.*;
import java.util.*;

public class Main {
    
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][][] visited;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	visited = new boolean[N][M][2];
    	for (int i = 0; i < N; i++) {
    		String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
    	int result = bfs();
    	System.out.println(result);
    }
    
    static int bfs() {
    	Deque<int[]> dq = new ArrayDeque<>();
    	visited[0][0][0] = true;
    	dq.offer(new int[] {0, 0, 0, 1});
    	while(!dq.isEmpty()) {
    		int[] cur = dq.poll();
    		int cr = cur[0];
    		int cc = cur[1];
    		int bw = cur[2];
    		int count = cur[3];
    		if(cr == N - 1 && cc == M - 1) return count;
    		for (int i = 0; i < 4; i++) {
    			int nr = cr + dr[i];
    			int nc = cc + dc[i];
    			
    			if(!check(nr, nc)) continue;
    			if(visited[nr][nc][bw]) continue;
    			if(map[nr][nc] == 0) {
    				visited[nr][nc][bw] = true;
    				dq.offer(new int[] {nr, nc, bw, count + 1});	
    			}
    			
    			if(map[nr][nc] == 1) {
    				if(bw == 0) {
        				visited[nr][nc][bw] = true;
        				dq.offer(new int[] {nr, nc, bw + 1, count + 1});
        			}
    			}
    		}	
    	}
    	return -1;
    }
    
    static boolean check(int nr, int nc) {
    	return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}
