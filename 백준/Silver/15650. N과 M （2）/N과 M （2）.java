import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		result = new int[M];
		visited = new boolean[N];
		func(0, 0);
		
	}
	
	static void func(int start, int cnt) {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(' ');
			}
			System.out.println(sb.toString());
			return;
		}
		for (int i = start; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			result[cnt] = arr[i];
			func(i + 1, cnt + 1);
			result[cnt] = 0;
			visited[i] = false;
		}
	}
}