import java.util.*;
import java.io.*;

public class Main {
	
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static int count = 0;
	
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
			}
		}
		
		for (int i = 0; i < R; i++) {
			if(dfs(i, 0)) count++;
		}
		System.out.println(count);
	}
	
	private static boolean dfs(int cr, int cc) {
		if(cc == C - 1) {
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int nr = cr + dr[i];
			int nc = cc + dc[i];
			if(!check(nr, nc)) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] == 'x') continue;
			visited[nr][nc] = true;
			if(dfs(nr, nc)) return true;
//			visited[nr][nc] = false;
		}
		return false;
	}
	
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
