import java.util.*;
import java.io.*;

public class Main {
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		while(w != 0 || h != 0) {
			int count = 1;
			map = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] != 1) continue;
					count++;
					ArrayDeque<int[]> dq = new ArrayDeque<>();
					dq.offer(new int[] {i, j});
					map[i][j] = count;
					while(!dq.isEmpty()) {
						int[] cur = dq.poll();
						for (int d = 0; d < 8; d++) {
							int nr = cur[0] + dr[d];
							int nc = cur[1] + dc[d];
							if(!check(nr, nc)) continue;
							if(map[nr][nc] != 1) continue;
							map[nr][nc] = count;
							dq.offer(new int[] {nr, nc});
						}
					}
				}
			}
			sb.append(count-1).append('\n');
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb.toString());
	}
	
	static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < h && nc < w;
	}
}