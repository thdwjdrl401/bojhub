import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			for(int w = 1; w <= N; w++) {
				if(w % 2 == 1) {
					sb.append("* ");
				}
			}
			sb.append('\n');
			for(int w = 1; w <= N; w++) {
				if(w % 2 == 0) {
					sb.append(" *");
				}
			}
			sb.append('\n');				
		}
		System.out.println(sb.toString());
	}
}
