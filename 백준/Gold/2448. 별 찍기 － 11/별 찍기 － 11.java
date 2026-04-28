import java.util.*;
import java.io.*;

public class Main {

	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int W = 2 * N - 1; 
		map = new char[N][W];
		for(int i = 0; i < N; i++) Arrays.fill(map[i],  ' ');
		draw(N, 0, N - 1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(map[i]).append('\n');
		}
		System.out.println(sb.toString());
	}
	
	private static void draw(int N, int r, int c) {
		if(N == 3) {
			map[r][c] = '*';
			map[r + 1][c - 1] = '*';
			map[r + 1][c + 1] = '*';
			for(int i = -2; i <= 2; i++) {
				map[r + 2][c + i] = '*';
			}
			return;
		}
		int half = N / 2;
		draw(half, r, c);
		draw(half, r + half, c - half);
		draw(half, r + half, c + half);
	}
}