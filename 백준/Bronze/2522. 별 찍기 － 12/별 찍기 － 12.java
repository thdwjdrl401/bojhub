import java.util.*;
import java.io.*;

public class Main {

	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int H = 2 * N - 1; 
		map = new char[H][N];
		StringBuilder sb = new StringBuilder();
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				if(x <= N - y - 2) sb.append(' '); 
				else sb.append('*');
			}
			sb.append('\n');
		}
		for(int y = N - 2; y >= 0; y--) {
			for(int x = 0; x < N; x++) {
				if(x <= N - y - 2) sb.append(' '); 
				else sb.append('*');
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}