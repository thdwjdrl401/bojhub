import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[19][19];
		int[] dc = new int[] {1, 0, 1, 1};
		int[] dr = new int[] {0, 1, 1, -1};
		
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				int cur = map[r][c];
				if(cur == 0) continue;
				int team = cur;
				
				for(int i = 0; i < 4; i++) {
					int pr = r - dr[i];
					int pc = c - dc[i];
					if(pr >= 0 && pc >= 0 && pr < 19 && pc < 19 && map[pr][pc] == team) continue;
					
					int count = 1;
					int nr = r + dr[i];
					int nc = c + dc[i];
					while(nr >= 0 && nc >= 0 && nr < 19 && nc < 19 && map[nr][nc] == team) {
						count++;
						nr += dr[i];
						nc += dc[i];
					}
					if(count == 5) {
						System.out.println(team);
						System.out.println((r + 1) + " " + (c + 1));
						return;
					}
					
				}
			}
		}
		System.out.println("0");
	}
}