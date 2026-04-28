import java.io.*;
import java.util.*;

public class Main {
    
	static int N, M;
	static int[][] map;
	static int[][] wMap;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        wMap = new int[N][M];
        for (int i = 0; i < N; i++) {
			Arrays.fill(wMap[i], Integer.MAX_VALUE);
		}
        for (int i = 0; i < N; i++) {
        	String s = br.readLine();
        	for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
        
        dijkstra();
        System.out.println(wMap[N-1][M-1]);
        
    }
    
    static void dijkstra() {
    	PriorityQueue<int[]> dq = new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a, int[] b) {
    			return Integer.compare(a[2], b[2]);
    		}
    	});
    	dq.offer(new int[] {0, 0, 0});
    	wMap[0][0] = map[0][0];
    	while(!dq.isEmpty()) {
    		int[] cur = dq.poll();
    		if(cur[0] == N -1 && cur[1] == M -1) break;
    		for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(!check(nr, nc)) continue;
				int nextWallCount = cur[2] + map[nr][nc];
				if(nextWallCount < wMap[nr][nc]) {
					wMap[nr][nc] = nextWallCount;
					dq.offer(new int[] {nr, nc, nextWallCount});
				}
				
			}
    	}
    }
    
    static boolean check(int r, int c) {
    	return r < N && c < M && r >= 0 && c >= 0;
    }
}