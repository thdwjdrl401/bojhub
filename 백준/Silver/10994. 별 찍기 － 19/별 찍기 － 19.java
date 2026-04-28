import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int HW = 4 * N - 3;
		map = new char[HW][HW];
		for(int i = 0; i < HW; i++) Arrays.fill(map[i],  ' ');
		
		draw(HW, HW / 2, HW / 2);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < HW; i++) {
			sb.append(map[i]).append('\n');
		}
		System.out.print(sb.toString());
	}
	private static void draw(int HW, int c, int r) {
		if(HW == 1) {
			map[c][r] = '*';
			return;
		}
		for(int i = -HW / 2; i <= HW / 2; i++) {
			for(int j = -HW / 2; j <= HW / 2; j++) {
				if(i == -HW / 2 || i == HW / 2) map[c + i][r + j] = '*';
				else if(j == -HW / 2 || j == HW / 2) map[c + i][r + j] = '*';
			}
		}
		
		draw(HW - 4, c, r);
	}
}
