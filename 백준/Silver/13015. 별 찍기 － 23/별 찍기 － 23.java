import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int leftBlank =  0;
		int innerBlank =  2 * N - 3;
		for(int i = 0; i < 2 * N - 1; i++) {
			for(int j = 0; j < leftBlank; j++) {
				sb.append(' ');
			}

			for(int j = 0; j < N; j++) {
				if(i == 0 || i == 2 * N - 2) {
					sb.append('*');
				} else if(j == 0 || j == N - 1) {
					sb.append('*');
				} else {
					sb.append(' ');
				}
			}
			for(int j = 0; j < innerBlank; j++) sb.append(' ');
			if(i == N - 1) sb.deleteCharAt(sb.length() - 1);
			for(int j = 0; j < N; j++) {
				if(i == 0 || i == 2 * N - 2) {
					sb.append('*');
				} else if(j == 0 || j == N - 1) {
					sb.append('*');
				} else {
					sb.append(' ');
				}
			}
			if(i < N - 1) {
				leftBlank++;
				innerBlank -= 2;				
			} else {
				leftBlank--;
				innerBlank += 2;
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}
