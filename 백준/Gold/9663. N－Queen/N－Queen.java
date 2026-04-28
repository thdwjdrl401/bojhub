import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int[][] map;
	static boolean[] checkC;
	static boolean[] checkRpC;
	static boolean[] checkRmC;
	static int count = 0;
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		checkC = new boolean[N];
		checkRpC = new boolean[2 * N - 1];
		checkRmC = new boolean[2 * N - 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
			}
		}
		
		dfs(0);
		System.out.println(count);
	}
	
	static void dfs(int r) {
		if(r == N) {
			count++;
			return;
		}
		for (int c = 0; c < N; c++) {
			if(checkC[c] || checkRpC[r + c] || checkRmC[r - c + N - 1]) continue;
			checkC[c] = true;
			checkRpC[r + c] = true;
			checkRmC[r - c + N - 1] = true;
			dfs(r + 1);
			checkC[c] = false;
			checkRpC[r + c] = false;
			checkRmC[r - c + N - 1] = false;
		}
	}
}