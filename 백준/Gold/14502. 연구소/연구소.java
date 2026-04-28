import java.io.*;
import java.util.*;

public class Main {
    
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static List<int[]> vlist;
	static List<int[]> blankList;
	static List<int[]> rollbackList;
	static int max = Integer.MIN_VALUE;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	vlist = new ArrayList<>();
    	blankList = new ArrayList<>();
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) vlist.add(new int[] {i, j});
				else if(map[i][j] == 0) blankList.add(new int[] {i, j});
			}
		}
    	dfs(0, 0);
    	System.out.println(max);
    	
    }
    static void dfs(int depth, int count) {
    	if(count == 3) {
    		simulation();
    		max = Math.max(max, blankList.size() - rollbackList.size() - 3);
    		rollback();
    		return;
    	}
    	for (int i = depth; i < blankList.size(); i++) {
        	int[] cur = blankList.get(i);
        	map[cur[0]][cur[1]] = 1;
        	dfs(i+1, count + 1);
        	map[cur[0]][cur[1]] = 0;
		}
    }
    
    static void simulation() {
    	rollbackList = new ArrayList<>();
    	Deque<int[]> dq = new ArrayDeque<>();
    	boolean[][] visited = new boolean[N][M];
    	for (int[] v : vlist) {
    		int vr = v[0];
    		int vc = v[1];
    		dq.offer(new int[] {vr, vc});
    		visited[vr][vc] = true;
    		while(!dq.isEmpty()) {
    			int[] cur = dq.poll();
    			int cr = cur[0];
    			int cc = cur[1];
    			for (int i = 0; i < 4; i++) {
					int nr = cr + dr[i];
					int nc = cc + dc[i];
					
					if(!check(nr, nc)) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] != 0) continue;
					visited[nr][nc] = true;
					rollbackList.add(new int[] {nr, nc});
					dq.offer(new int[] {nr, nc});
				}
    		}
    		
		}
    	
    }
    
    static void rollback() {
    	for(int[] cur : rollbackList) {
    		map[cur[0]][cur[1]] = 0;
    	}
    }
    
    static boolean check(int nr, int nc) {
    	return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}
