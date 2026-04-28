import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		result = Integer.MAX_VALUE;
		dfs(0, 1, 0, 0);
		System.out.println(result);
	}
	
	static void dfs(int depth, int mul, int sum, int count) {
		if(depth == N) {
			if(count != 0) {
				result = Math.min(result, Math.abs(mul - sum));
			}
			return;
		}
		dfs(depth + 1, mul * arr[depth][0], sum + arr[depth][1], count + 1);
		dfs(depth + 1, mul, sum, count);			
	}
	
}
