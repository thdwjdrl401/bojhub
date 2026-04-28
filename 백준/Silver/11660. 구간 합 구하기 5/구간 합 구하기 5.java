import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static int M;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				dp[i][j] = cur + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			int result = dp[y2][x2] - dp[y1 - 1][x2] - dp[y2][x1 -1] + dp[y1-1][x1-1];
			sb.append(result).append('\n');
		}
		System.out.println(sb.toString());
	}
}
