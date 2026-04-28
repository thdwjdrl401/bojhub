import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				if(x <= y) sb.append('*'); 
//				else sb.append(' ');
			}
			sb.append('\n');
		}
		for(int y = N - 2; y >= 0; y--) {
			for(int x = 0; x < N; x++) {
				if(x <= y) sb.append('*'); 
//				else sb.append(' ');
			}
			sb.append('\n');
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}
}