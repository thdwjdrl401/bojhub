import java.io.*;
import java.util.*;

public class Main {
    
	static int N, M;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][][] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visited = new boolean[N][M][1<<6];
        int sr = 0, sc = 0;
        for (int i = 0; i < N; i++) {
        	String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '0') {
					sr = i;
					sc = j;
					map[i][j] = '.';
				}
			}
		}
        
        int result = bfs(sr, sc);
        System.out.println(result);
    }
    
    static int bfs(int sr, int sc) {
    	Deque<int[]> dq = new ArrayDeque<>();
    	dq.offer(new int[] {sr, sc, 0, 0});
    	
    	while(!dq.isEmpty()) {
    		int[] cur = dq.poll();
    		int cr = cur[0];
    		int cc = cur[1];
    		int key = cur[2];
    		int count = cur[3]; 
    		if(map[cr][cc] == '1') return count;
    		
    		
    		for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				int curKey = key;
				if(!check(nr, nc)) continue;
				char ch = map[nr][nc];
				if(ch == '#') continue;
				if(visited[nr][nc][key]) continue;
				if(ch >= 'A' && ch <= 'F') {
					if((curKey >> (ch - 'A')) % 2 != 1) continue;
				}
				if(ch >= 'a' && ch <= 'f') {					
					curKey |= 1 << (ch - 'a');
				}
				visited[nr][nc][curKey] = true;
				dq.offer(new int[] {nr, nc, curKey, count + 1});
			}
    	}
    	return -1;
    }
    
    static boolean check(int nr, int nc) {
    	return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}