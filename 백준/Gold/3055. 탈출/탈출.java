import java.io.*;
import java.util.*;

public class Main {
    
	static int R, C;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int ddr, ddc, sr, sc;
	static boolean[][] visited;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> nextList;

	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
        	String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'D') {
					ddr = i;
					ddc = j;
				} else if(map[i][j] == 'S') {
					sr = i;
					sc = j;
				} else if(map[i][j] == '*') {
					list.add(new int[] {i, j});
				}
			}
		}

        int result = bfs();
        System.out.println(result == -1 ? "KAKTUS" : result);
    }
    
    static int bfs() {
    	Deque<int[]> dq = new ArrayDeque<>();
    	visited[sr][sc] = true;
    	dq.offer(new int[] {sr, sc, 0});
    	int preTime = -1;
    	while(!dq.isEmpty()) {
    		int[] cur = dq.poll();
    		int cr = cur[0];
    		int cc = cur[1];
    		int curTime = cur[2];
    		if(map[cr][cc] == 'D') return curTime;
    		if(preTime != curTime) {
    			nextList = new ArrayList<>();
    			// 여기는 시간이 지날 때마다 물을 차올라줘여
    			for(int[] c : list) {
    				for (int i = 0; i < 4; i++) {
						int nr = c[0] + dr[i];
						int nc = c[1] + dc[i];
						if(!check(nr, nc)) continue;
						if(map[nr][nc] == '.') {
							map[nr][nc] = '*';
							nextList.add(new int[] {nr, nc});
						}
					}
    			}
    			list = nextList;
    			
    			preTime = curTime;
    		}
    		for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == '*' || map[nr][nc] == 'X') continue;
				visited[nr][nc] = true;
				dq.offer(new int[] {nr, nc, curTime + 1});
			}
    	}
    	return -1;
    }
    
    static boolean check(int nr, int nc) {
    	return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}