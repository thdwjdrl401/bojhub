import java.util.*;
import java.io.*;

public class Main {
	static int R;
	static int C;
	static int T;
	static int[][] map;
	static int mUp, mDn;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					mDn = i;
				}
			}
		}
		mUp = mDn - 1;
		
		for (int i = 0; i < T; i++) {
			step1();
			step2();
		}
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += map[i][j];
			}
		}
		System.out.println(result + 2);
	}
	
	private static void step1() {
		Deque<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0) dq.offer(new int[] {i, j, map[i][j]});
			}
		}
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int cr = cur[0];
			int cc = cur[1];
			int cn = cur[2];

			int count = 0;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == -1) continue;
				count++;
				map[nr][nc] += cn  / 5;
			}
			map[cr][cc] -= (cn / 5) * count;
		}
	}
	
	private static void step2() {
		for (int i = mUp; i > 0; i--) map[i][0] = map[i - 1][0];
		for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
		for (int i = 0; i < mUp ; i++) map[i][C - 1] = map[i + 1][C - 1];
		for (int i = C - 1; i > 0 ; i--) map[mUp][i] = map[mUp][i - 1];
		map[mUp][0] = -1;
		map[mUp][1] = 0;
		
		for (int i = mDn; i < R - 1; i++) map[i][0] = map[i + 1][0];
		for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
		for (int i = R - 1; i > mUp ; i--) map[i][C - 1] = map[i - 1][C - 1];
		for (int i = C - 1; i > 0 ; i--) map[mDn][i] = map[mDn][i - 1];
		map[mDn][0] = -1;
		map[mDn][1] = 0;
	}
	
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}
}