import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		if(N == 1) {
			System.out.println("*");
			return;
		}
		int H = 4 * N - 1;
		int W = 4 * N - 3;
		
		map = new char[H][W];
		
		for(int i = 0; i < H; i++) Arrays.fill(map[i], ' ');
		draw(N, 0, 0);

		for(int i = 0; i < H; i++) {
			if(i == 1) {
				sb.append('*').append('\n');
			}else {
				sb.append(map[i]).append('\n');				
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void draw(int N, int c, int r) {	
		int H  = 4 * N  - 1;
		int W = 4 * N - 3;
		int rightR = W + r - 1;
		int bottomC = H + c - 1;
		
		if(N == 1) {
			map[c + H / 2 + 1][r + W / 2] = '*';
			return;
		} else if(N == 2) {
			map[c + 2][r + 2] = '*';
			map[c + 3][r + 2] = '*';
		}
		
		// 위의 가로줄
		for(int i = 0; i < W; i++) {
			map[c][r + i] = '*';
		}
		// 왼쪽 세로줄
		for(int i = 0; i < H - 1; i++) {
			map[c + i][r] = '*';
		}
		// 아래 가로줄
		for(int i = 0; i < W; i++) {
			map[bottomC][r + i] = '*';
		}
		// 오른쪽 세로줄
		for(int i = 2; i < H - 1; i++) {
			map[c + i][rightR] = '*';
		}
		map[c + 2][rightR - 1] = '*';
		
		draw(N - 1, c + 2, r + 2);
	}
}