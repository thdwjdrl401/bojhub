import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)count++;
			}
		}
		int result1 = 0;
		int result2 = 0;
		while(count > 0) {
			result1++;
			result2 = count;
			bf2(0, 0, 0, 0);
		}
		System.out.println(result1);
		System.out.println(result2);
	}
	static void bf2(int sr, int sc, int target, int to) {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		dq.offer(new int[] {sr, sc});
		map[sr][sc] = to;
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(!check(nr, nc))continue;
				if(visited[nr][nc])continue;
				if(map[nr][nc] == target) {
					visited[nr][nc] = true;
					map[nr][nc] = to;
					dq.offer(new int[] {nr, nc});	
				} else if(map[nr][nc] == 1) {
					visited[nr][nc] = true;
					map[nr][nc] = to;
					count--;
				}
			}
		}
	}
	
	static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}
