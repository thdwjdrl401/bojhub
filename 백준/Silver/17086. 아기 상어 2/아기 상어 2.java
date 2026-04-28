import java.util.*;
import java.io.*;

class Main {
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0, -1, 1, 1, -1};
	static int[] dc = {0, -1, 0, 1, 1, 1, -1, -1};
	static List<int[]> list = new ArrayList<>();
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				list.add(new int[] {r, c});
			}
		}
		int max = Integer.MIN_VALUE;
		for(int[] cur : list) {
			int dis = bfs(cur[0], cur[1]);
			max = Math.max(max,  dis);
		}
		
		System.out.println(max);
	}
	
	static int bfs(int cr, int cc) {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		dq.offer(new int[] {cr, cc, 0});
		visited[cr][cc] = true;
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int dis = cur[2];
			if(map[cur[0]][cur[1]] == 1) return dis;
			for (int i = 0; i < 8; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				dq.offer(new int[] {nr, nc, dis + 1});
			}
		}
		return 0;
	}
	
	static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}