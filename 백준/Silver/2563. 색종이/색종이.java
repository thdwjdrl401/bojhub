import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] position;
	static boolean[][] map = new boolean[101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[r+i][c + j] = true;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]) count++;
			}
		}
		
		System.out.println(count);
	}
}