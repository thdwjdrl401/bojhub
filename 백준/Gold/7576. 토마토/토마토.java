import java.util.*;
import java.io.*;

class Main {
	static int M;
	static int N;
//	static int H;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	static Deque<int[]> goodT = new ArrayDeque<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
//	static int[] dr = {-1, 0, 1, 0, 0, 0};
//	static int[] dc = {0, 1, 0, -1, 0, 0};
//	static int[] dh = {0, 0, 0, 0, 1, -1};
	
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int count = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] == 1) goodT.offer(new int[] {n, m});
				else if(map[n][m] == 0) count++;
			}
		}
		Deque<int[]> nextGoodT;
		int result = 0;
		do  {
			nextGoodT = new ArrayDeque<>();
			while(!goodT.isEmpty()) {
				int[] cur = goodT.poll();
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					if(!check(nr, nc)) continue;

					if(map[nr][nc] == -1 || map[nr][nc] == 1) continue;
					if(map[nr][nc] == 0) {
						map[nr][nc] = 1;	
						nextGoodT.offer(new int[] {nr, nc});
						count--;
					}
				}
			}
			if(!nextGoodT.isEmpty()) result++;
			goodT = nextGoodT;
		} while(!nextGoodT.isEmpty());
		System.out.println(count != 0 ? -1 : result);
	}
	
	static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}