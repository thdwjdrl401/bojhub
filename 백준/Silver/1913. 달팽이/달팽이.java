import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		int[][] map = new int[N][N];
		int num = 1;
		int step = 1;
		int x = N / 2;
		int y = N / 2;
		while (num <= N * N) {
			for (int direction = 0; direction < 4 && num <= N * N; direction++) {
				for (int j = 0; j < step && num <= N * N; j++) {
                    if (x < 0 || x >= N || y < 0 || y >= N) break;
					map[y][x] = num++;
					x += dx[direction];
					y += dy[direction];
				}
				if(direction % 2 == 1) step++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cur = map[i][j];
				sb.append(cur);
				sb.append(' ');
				if(cur == target) {
					y = i + 1;
					x = j + 1;
				}
			}
			sb.append('\n');
		}
		sb.append(y + " " + x);
		System.out.println(sb.toString());
	}
}