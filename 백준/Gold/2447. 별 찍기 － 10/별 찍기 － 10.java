import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] pattern = new boolean[][] {{true, true, true}, {true, false, true}, {true, true, true}};
		boolean[][] result = new boolean[N][N];
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(isBlank(i, j)) sb.append(" ");
				else sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static boolean isBlank(int r, int c) {
	    while (r > 0 || c > 0) {
	        if (r % 3 == 1 && c % 3 == 1) return true;
	        r /= 3;
	        c /= 3;
	    }
	    return false;
	}

}
