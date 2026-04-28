import java.io.*;
import java.util.*;

public class Main {
    
	static int N;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine() );
        map = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
        int result = 1;
        for (int limit = 1; limit <= max; limit++) {
        	int count = 1;
        	boolean[][] visited = new boolean[N][N];
        	for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cr = i;
	            	int cc = j;
	        		if(visited[cr][cc]) continue;
	        		if(map[cr][cc] <= limit) continue;
	            	Deque<int[]> dq = new ArrayDeque<>();
	            	dq.offer(new int[] {cr, cc});
	            	visited[cr][cc] = true;
	            	while(!dq.isEmpty()) {
	            		int[] next = dq.poll();
	            		for (int d = 0; d < 4; d++) {
	            			int nr = next[0] + dr[d];
	                		int nc = next[1] + dc[d];					
	                		if(!check(nr, nc)) continue;
	                		if(visited[nr][nc]) continue;
	                		if(map[nr][nc] <= limit) continue;
	                		
	                		visited[nr][nc] = true;
	                		dq.offer(new int[] {nr, nc});
	    				}
	            	}
	            	count++;
				}
			}
        	result = Math.max(result, count - 1);
        }
        System.out.println(result);
    }
    
    static boolean check(int nr, int nc) {
    	return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
}
