import java.util.*;
import java.io.*;

public class Main {
	
	static int R = 12;
	static int C = 6;
	static char[][] map = new char[R][C];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int count = 0;
		while(true) {
			List<int[]> boomList = boom();
//			System.out.println();

			if(boomList.isEmpty()) break;
			down(boomList);
			count++;
		}
		System.out.println(count);
		
	}
	static void down(List<int[]> boomList) {
		boolean[] visited = new boolean[C];
		for(int[] position : boomList) {
			if(visited[position[1]]) continue;
			visited[position[1]] = true;
			List<Character> list = new ArrayList<>();
			for (int i = R - 1; i >= 0; i--) {
				if(map[i][position[1]] != '.') list.add(map[i][position[1]]);
			}
			int index = R - 1;
			for (int i = 0; i < R; i++) {
				map[index--][position[1]] = list.size() > i ? list.get(i) : '.'; 
			}
		}
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();

	}
	
	static List<int[]> boom() {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		List<int[]> boomList = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.') continue;
				if(visited[i][j]) continue;
				dq.offer(new int[] {i, j});
				visited[0][0] = true;
				char curC = map[i][j];
				int count = 0;
				List<int[]> subList = new ArrayList<>();
				while(!dq.isEmpty()) {
					int[] cur = dq.poll();
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if(!check(nr, nc)) continue;
						if(visited[nr][nc]) continue;
						if(curC != map[nr][nc]) continue;
						visited[nr][nc] = true;
						dq.offer(new int[] {nr, nc});
						subList.add(new int[] {nr, nc});
						count++;
					}
				}
				if(count >= 4) {
					boomList.addAll(subList);
				}
			}
		}
		for(int[] n : boomList) {
			map[n[0]][n[1]] = '.';
		}
		return boomList;
	}
	
	static boolean check(int sr, int sc) {
		return sr >= 0 && sc >= 0 && sr < R && sc < C;
	}
}
