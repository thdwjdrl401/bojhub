import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int W, H;
    static int[][] map;
    static int[] hMoveR = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hMoveC = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] mMoveR = {-1, 0, 1, 0};
    static int[] mMoveC = {0, 1, 0, -1};
    static int[][][] move = {{{-1, 0, 1, 0}, {0, 1, 0, -1}}, {{-2, -1, 1, 2, 2, 1, -1, -2}, {1, 2, 2, 1, -1, -2, -2, -1}}};
    static boolean[][][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        int result = bfs();
        System.out.println(result);
    }
    static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {0, 0, K, 0});
        while(!dq.isEmpty()) {
        	int[] cur = dq.poll();
        	int cr = cur[0];
        	int cc = cur[1];
        	int k = cur[2];
        	int time = cur[3];
        	if(cr == H - 1 && cc == W - 1) return time;
        	
        	for (int i = 0; i < 4; i++) {
				int nr = cr + mMoveR[i];
				int nc = cc + mMoveC[i];
				
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == 1) continue;
				if(visited[nr][nc][k]) continue;
				visited[nr][nc][k] = true;
				dq.offer(new int[] {nr, nc, k, time + 1});
			}
        	if(k > 0) {
        		k--;
        		for (int i = 0; i < 8; i++) {
					int nr = cr + hMoveR[i];
					int nc = cc + hMoveC[i];
					
					if(!check(nr, nc)) continue;
					if(map[nr][nc] == 1) continue;
					if(visited[nr][nc][k]) continue;
					visited[nr][nc][k] = true;
					dq.offer(new int[] {nr, nc, k, time + 1});
				}
        	}
        }
        return -1;
    }
    
    static boolean check(int nr, int nc) {
    	return nr >= 0 && nc >= 0 && nr < H && nc < W;
    }
}