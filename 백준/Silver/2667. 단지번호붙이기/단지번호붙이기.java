import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int count = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cur = map[i][j];
				if(cur != 1) continue;
				count++;
				ArrayDeque<int[]> dq = new ArrayDeque<>();
				dq.offer(new int[] {i, j});
				map[i][j] = count;
				int n = 1;
				while(!dq.isEmpty()) {
					int[] curArr = dq.poll();
					for (int d = 0; d < 4; d++) {
						int nr = curArr[0] + dr[d];
						int nc = curArr[1] + dc[d];
						if(!check(nr, nc)) continue;
						if(map[nr][nc] != 1) continue;
						map[nr][nc] = count;
						dq.offer(new int[] {nr, nc});
						n++;
					}
				}
				list.add(n);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(count - 1).append('\n');
		
		list.sort(Comparator.naturalOrder());
		for(int l : list) {
			sb.append(l).append('\n');
		}
		System.out.print(sb.toString());
	}
	
	static boolean check(int nr, int nc){
		return nr >= 0 && nc >= 0 && nr < N && nc < N; 
	} 
}