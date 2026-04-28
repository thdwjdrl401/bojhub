import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] key;
    static List<int[]>[] doors;
    static StringBuilder sb = new StringBuilder();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	h = Integer.parseInt(st.nextToken());
        	w = Integer.parseInt(st.nextToken());
        	map = new char[h + 2][w + 2];
        	visited = new boolean[h + 2][w + 2];
        	for (int i = 1; i <= h; i++) {
				String s = br.readLine();
				for (int j = 1; j <= w; j++) {
					char c = s.charAt(j - 1);
					map[i][j] = c;
				}
			}
        	
        	String defaultKeys = br.readLine();
            key = new boolean[26];
            if(!defaultKeys.equals("0")) {
        		for (int i = 0; i < defaultKeys.length(); i++) {
					char c = defaultKeys.charAt(i);
					key[c - 'a'] = true;
				}
        	}
            doors = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
            	doors[i] = new ArrayList<>();
			}
            sb.append(bfs(0, 0)).append('\n');
		}
        System.out.println(sb);
    }
    
    static int bfs(int sr, int sc) {
    	Deque<int[]> dq = new ArrayDeque<>();
    	dq.offer(new int[] {sr, sc});
        visited[sr][sc] = true;
        int count = 0;
    	while(!dq.isEmpty()) {
    		int[] cur = dq.poll();
    		for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(!check(nr, nc)) continue;
				char mapC = map[nr][nc];
                if (visited[nr][nc]) continue;
				if(mapC == '*') continue;
				if(mapC >= 'A' && mapC <= 'Z') {
					int idx = mapC - 'A';
					if(!key[idx]) {
						doors[idx].add(new int[] {nr, nc});
						continue;
					}
				}
				if(mapC >= 'a' && mapC <= 'z') {
					int index = mapC - 'a';
					key[index] = true;
					for (int[] door : doors[index]) {
						if(visited[door[0]][door[1]]) continue;
						visited[door[0]][door[1]] = true;
						dq.offer(new int[] {door[0], door[1]});
					}
				}
				visited[nr][nc] = true;
				if(mapC == '$') count++;
				dq.offer(new int[] {nr, nc});
			}
    	}
    	return count;
    }
    
    static boolean check(int nr, int nc) {
    	return nr <= h + 1 && nc <= w + 1 && nr >= 0 && nc >= 0;
    }
}








